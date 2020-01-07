#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<time.h>
#include<unistd.h>
/*
	Μεταβλητές ακέραιου τύπου και global εμβέλειας για τον αριθμό των φιλοσόφων και για το 
	πόσες φορές οι φιλόσοφοι μπήκαν στην κατάσταση αναμονής.
*/
int p, ti;
//Μεταβλητή τύπου δεκαδιού για τον συνολικό χρόνο που οι φιλόσοφοι βρέθηκαν στην κατάσταση αναμονής.
double total;
/*
	Το struct χρησιμοποιείται για να ορίσει ένα μπλοκ μεταξύ thread, mutexes και μεταβλητών που αντιπροσωπεύουν
	ένα φιλόσοφο.
	Ένας φιλόσοφος ορίζεται σαν ένα thread/νήμα.
	Τα 2 πιρούνια ορίζονται σαν  mutexes.
*/
typedef struct phi
{
	//Δημιουργία φιλοσόφου/νήματος
	pthread_t thread;
	/*
		Δημιουργία 2 πιρουνιών/mutex για κάθε φιλόσοφο/νήμα.
		
		(fl = fork left)	(philosopher)		(fr = fork right)		

	*/ 
	pthread_mutex_t *fl, *fr;
	//Ακέραιος για την αρίθμιση του εκάστοτε φιλοσόφου.	
	int idtracker;
	/*
		Μεταβλητή που ορίζει αν ένας φιλόσοφος έχει τελειώσει το γεύμα του.
		0: ο φιλόσοφος δεν έχει τελειώσει το γεύμα του.
		1: ο φιλόσοφος έχει τελειώσει το γεύμα του.	
	*/
	int ready;
	//Μεταβλητή για την προτεραιότητα του φιλοσόφου.
	int priority;
	//Μεταβλητή που καταγράφει πόση ώρα έχει δειπνήσει ένας φιλόσοφος.
	int tiktok;	
	//Μεταβλητή που καταγράφει πόση ώρα έχει περάσει ένας φιλόσοφος στο Hungry mode.
	double hm;
	//Η μεταβλητή μετράει πόσες φορές ένας φιλόσοφος μπήκε στην κατάσταση αναμονής.
	int hmtimes;
} ph;

//Συνάρτηση που επιστρέφει την τοπική ώρα σε μορφή πίνακα χαρακτήρων/string.
const char* Time()
{
	struct tm* local; 
    time_t t = time(NULL);
    local = localtime(&t); 
	return asctime(local);
}

/*
	Συνάρτηση για την εκτέλεση του κάθε φιλοσόφου. 
	Δέχεται σαν όρισμα των pointer που δείχνει ποιος φιλόσοφος είναι από αυτούς 
	που κατασκέυαστηκες βάση του struct.
*/
void *Paranoid(void *x)
{
	//Ορίζεται σαν "πρώτος" φιλόσοφος ο: philosopher.
	ph *philosopher = (ph *)x;
	//Ακεραίου τύπου μεταβλητές για τον επόμενο, προηγούμενο φιλόσοφο και το bonus.
	int other_philosopher;
	//Ορισμοός ρολογιού με όνομα t.
	clock_t t;
	//Loop: Όσο ο χρόνος του εκάστοτε φιλοσόφου είναι μικρότερος των 20sec συνέχισε.
	while(philosopher->tiktok < 20)
	{	
		printf("Philosopher %d is thinking log:  %s \n", philosopher->idtracker, Time());
		/*	
			Ο φιλόσοφος/νήμα τίθεται σε κατάσταση ύπνου για "τυχαίο χρόνο"
			Ο τυχαίος χρόνος βγαίνει από τον τύπο: (Τυχαίος ακέαιος modulo 3) 
			που επιστρέφει αριθμός μετξύ του 0 και του 2 συν 1(για την περίπτωση του 0 ή πολλάπλασιων του 3). 
			Έτσι ο το νήμα θα κοιμηθεί μεταξύ των 1 και 3 δευτερολέπτων. 
			Αντίστοιχα αντί για 3 μπορούμε να βάλουμε οποιδήποτε αριθμό. 
			Επιλέχθηκε το 3 για συντομία χρόνου εκτέλεσης του προγράμματος συνολικά.
		*/
		sleep(rand()%3 + 1);
		printf("Philosopher %d is hungry log: %s \n", philosopher->idtracker, Time());
		//Αρχή του ρολογιού (Μέτρηση χρόνου στην κατάσταση hungry.
		t = clock();
		//Προσπάθεια του φιλοσόφου να πάρει το δεξί πιρούνι.
		if(pthread_mutex_trylock(philosopher->fr) != 0)
		{
			/*
				Για το αριστερό πιρούνι διακρίνου την εξής πείπρωση.
				Έστω ότι έχομε 3 φιλοσόφους, P0, P1, P2 και τα αντίστοιχα πιρούνια f0, f1, f2.
					
									P2		f2												
												P0
									f1		f0
										P1		
				Αν βρισκόμαστε στον Φιλόσοφο 0 τότε το δεξί πιρούνι είναι το 2
				και ο φιλόσοφος στα δεξιά είναι ο 2.
				Αν βρισκόμαστε στον Φιλόσοφο 1 τότε το δεξί πιρούνι είναι το 0
				και ο φιλόσοφος στα δεξιά είναι ο 0.
				Αν βρισκόμαστε στον Φιλόσοφο 2 τότε το δεξί πιρούνι είναι 1
				και ο φιλόσοφος στα δεξιά είναι ο 1.		
			*/
			if(philosopher->idtracker == 0)
			{
				other_philosopher = p - 1;
			}
			else
			{
				other_philosopher = philosopher->idtracker - 1;
			}
			printf("Philosopher %d failed to take right fork %d cause Philosopher %d was using it log: %s \n",philosopher->idtracker, other_philosopher, other_philosopher, Time());
			//Ο φιλόσοφος "κλειδώνει" το δεξί πιρούνι.
			pthread_mutex_lock(philosopher->fr);			
		}
		//Προπάθεια του φιλοσόφου να πάρει το αριστερό πιρούνι.
		if(pthread_mutex_trylock(philosopher->fl) != 0)
		{
			/*
				Για το αριστερό πιρούνι διακρίνου την εξής πείπρωση.
				Έστω ότι έχομε 3 φιλοσόφους, P0, P1, P2 και τα αντίστοιχα πιρούνια f0, f1, f2.
					
									P2		f2												
												P0
									f1		f0
										P1		
				Αν βρισκόμαστε στον Φιλόσοφο 0 τότε το αριστερό πιρούνι είναι το 0 
				και ο φιλόσοφος στα αριστερά είναι ο 1.
				Αν βρισκόμαστε στον Φιλόσοφο 1 τότε το αριστερό πιρούνι είναι το 1
				και ο φιλόσοφος στα αριστερά είναι ο 2.
				Αν βρισκόμαστε στον Φιλόσοφο 2 τότε το αριστερό πιρούνι είναι το 2
				και ο φιλόσοφος στα αριστερά είναι ο 0.
			*/
			if(philosopher->idtracker == p - 1)
			{
				other_philosopher = 0;
			}
			else
			{
				other_philosopher = philosopher->idtracker + 1;
			}
			printf("Philosopher %d failed to take left fork %d cause Philosopher %d was using it log: %s \n",philosopher->idtracker, philosopher->idtracker, other_philosopher, Time());
			//Ο φιλόσοφος "κλειδώνει" το αριστερό πιρούνι.
			pthread_mutex_lock(philosopher->fl);
		}
		//Ο χρόνος αναμονής τελειώνει. Άρα σταματά το ρολόι.
		t = clock() -t;
		//Καταχώρηση της ώρας αναμονής, πόση ώρα πέρασε μέχρι ο φιλόσοφος να πάρει και τα δύο πιρούνια.
		philosopher->hm = philosopher->hm + ((double)t)/CLOCKS_PER_SEC;
		total = total + ((double)t)/CLOCKS_PER_SEC;
		//Αύξηση του μετρητή για το Hungry mode.
		ti++;
		philosopher->hmtimes++;	
		printf("Philosopher %d is eating log: %s \n", philosopher->idtracker, Time());
		//Ο φιλόσοφος τρώει. Κοιμάται όσα seconds είναι και η προτέραιοτητά του.
		sleep(philosopher->priority);
		/*		
			Ο συνολικός χρόνος που έφαγε ο φιλόσοφος, είναι όσο και η προτεραιότητά του. 
			Οπότε μπορούμε να μετρήσουμε το συνολικό χρόνο μόνο με ένα ακέραιο, 
			αυξάνοντάς τον όσο η εκάστοτε προτεραιότητα.
		*/
		philosopher->tiktok = philosopher->tiktok + philosopher->priority;
		/* Παρομοίως θα συνέβαινε και στον πίνακα που κρατούσε το χρόνο.
		ti[philosopher->idtracker] = philosopher->tiktok;
		*/
		//Ο φιλόσοφος πέρασε priority seconds στο Eating mode. Οπότε "ξεκλειδώνει" τα πιρούνια.
		pthread_mutex_unlock(philosopher->fr);
		pthread_mutex_unlock(philosopher->fl);
	}
	//Η λήξη της επανάληψης σηματοδωτεί τη λήξη του γεύματος του φιλοσόφου.
	philosopher->ready = 1;
	printf("\n\n\n\n\nPhilosopher %d left the table log: %s \n\n\n\n\n\n", philosopher->idtracker, Time());
	return NULL;
}

//Η συνάρτηση "ελέγχει" τους φιλοσόφους. Δέχεται σαν όρισμα των αριθμό των φιλοσόφων.
void OneToRuleThemAll(int p)
{	
	//Πίνακας των threads/φιλοσόφων. Δημιουργία p θέσεων σε πίνακα όσοι και οι φιλόσοφοι.
	ph philosophers[p];
	/*	
		Ο pointer Philosopher ορίζεται ως ο πρώτος φιλόσοφος και δείχνει την αρχή της "αλυσίδας" στοιχείων
		που θα δημιουργηθούν από το struct
	*/
	ph *philosopher; 
	//Πίνακας τύπου mutex και μεγέθους όσο και οι φιλόσοφοι,που αντιπροσωπεύει τα "πιρούνια".
	pthread_mutex_t forks[p];
	for(int i = 0; i < p; i++)
	{
		//Αρχικοποίηση των στοιχείων του κάθε φιλοσόφου.
		pthread_mutex_init(&forks[i],NULL);
		//ti[i] = 0;
		philosopher = &philosophers[i];
		/*
			Ο αριθμός των πιρουνιών που αντιστοιχούν σε κάθε φιλόσοφο.
			Το δεξί πιρούνι είναι απλά ο αριθμός του φιλοσόφου.
			Το αριτερό πιρούνι Είναι το modulo μεταξύ του μετρητή (αυξημένου κατά 1 για την περίπτωση που
			είμαστε στον "τελευταίο" φιλίσοφο) και του συολικού αριθμού φιλοσόφων.
		*/		
		philosopher->fr = &forks[i];
		if(i == 0)
		{
			philosopher->fl = &forks[p - 1];
		}
		else
		{
			philosopher->fl = &forks[i - 1];
		}
		philosopher->idtracker = i;
		philosopher->ready = 0;
		/*
			Η τυχαία προτεραιότητα βγαίνει από τον τύπο: (Τυχαίος ακέαιος modulo 3)
			που επιστρέφει αριθμός μετξύ του 0 και του 2 συν 1(για την περίπτωση του 0 ή πολλάπλασιων του 3).
			Έτσι ο το νήμα/φιλόσοφος θα έχει προτεραιότητα, ισοπίθανα, μεταξύ των 1 και 3.
			Αντίστοιχα αντί για 3 μπορούμε να βάλουμε οποιδήποτε αριθμό-προτεραιότητα.
		*/
		philosopher->priority = rand() % 3 + 1;
		//Χρόνος που περνά ο φιλόσοφος στην κατάσταση που τρώει.		
		philosopher->tiktok = 0;
		//Χρόνος που περνά ο φιλόσοφος στην κατάσταση που πεινά.
		philosopher->hm = 0.0;
		//Μετρητής για το πόσες φορές ο φιλόσοφος μπήκε στην κατάσταση που πεινά.
		philosopher->hmtimes = 0;
		//Δημιουργία του φιλοσόφου/thread. Με κρίσημο σημείο την συνάρτηση *Paranoid.
		pthread_create(&philosopher->thread,NULL,Paranoid,philosopher);
	}
	while(1)
	{
		//Μετράει κάθε φορά πόσες διεργασίες έχουν πλήρως εκτελεστεί, "διατρέχωντας" το struct.
		int ready_philosophers = 0;
		for(int i = 0; i < p; i++)
		{
			philosopher = &philosophers[i];
			if(philosopher->ready )
			{
				ready_philosophers++;
			}
		}
		/*
			Εάν ο μετρητής ready_philosophers ισούται με τον αριθμό των
			φιλοσόφων, τότε διατρέχουμε ένα προς ένα τα thread "σκοτώνοντάς" τα.
			Μαζί και τα πιρούνια αντίστοιχα.
		*/
		if(ready_philosophers == p)
		{
			printf("Philosophers are ready! \n");
			for(int i = 0; i < p; i++)
			{
				philosopher = &philosophers[i];
				pthread_join(philosopher->thread, NULL);
				pthread_mutex_destroy(&forks[i]);
				printf("Philosopher %d spent %f in hm %d times with priority %d.\n", philosopher->idtracker, philosopher->hm/philosopher->hmtimes, philosopher->hmtimes, philosopher->priority);
			}
			printf("A Philosopher stayed hungry for aproximately %f minutes.", total/ti);
			break;
		}
	}
}

//Κύρια συνάρτηση.
void main(int argc, char *argv[])
{
	while(1)
	{	
		printf("Please input the number of philosophers (Number accepted 3 <= Philosophers <= 10): ");
		scanf("%d", &p);
		if( (p>=3) && (p<=10) )
		{
			break;
		}
	}
	ti = 0;
	total = 0.0;
	//Συνάρτηση για τη δημιουργία και τον έλεγχο των φιλοσόφων.
	OneToRuleThemAll(p);
}
