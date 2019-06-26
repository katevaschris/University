/*
	Main Authors: Pakou Eva, Katevas Chris

	Pakou Eva
	p18118
	github: https://github.com/Evaggelia18

	Katevas Chris
	p18068
	github: https://github.com/katevaschris
	
	Athens 2, April 2019
	
	Main purpose: 
*/
#include<stdio.h>
#include <stdlib.h>

/*
  Το struct node ειναι η δομή των κομβων της λίστας για κάθε μη
  μηδενικό στοιχείο.Περιέχει έναν ακέραιο για την τιμή του στοιχείου,
  δύο ακεραίους για τις συντεταγμένες του στοιχείου στον πίνακα και 
  ένα δείκτη για το επόμενο μη μηδενικό στοιχείο
*/

typedef struct node 
{
    int val;
    int col;
    int row;
    struct node * next;
} node_t;

int main()
{
	//Δήλωση και εισαγωγή του μήκους και του πλάτους του πίνακα Α
	printf("Input height and width Of Matrix A and B:\n ");
	int h, w;
	int f = 1;
	scanf("%d", &h);
	scanf("%d", &w);

	/*
	  Δήλωση του πήνακα C,ο οποίος θα περιέχει τα αποτελέσματα, και της μεταβλητης a,
	  η οποια χρησιμοποιείται για την εισαγωγή των στοιχείων στις διασυνδεδεμένες λίστες
	*/
	int c[h][w], a;
	/*
	  Δημιουργία "κόμβου"(μπλοκ μεταβλητών με τη βοήθεια του struct) με όνομα head. Η συνάρτηση malloc δίνει ακριβως το μέγεθος που χρειάζονται οι αντίστοιχες μεταβλητές. 
	*/
	node_t * head = malloc(sizeof(node_t));

	//Εισαγωγή της μήτρας Α μέσω εμφωλευμένων επαναλήψεων.
	printf("Please input matrix A:\n");
	for (int i = 0; i <h; ++i)
	{
		for(int j=0; j<w; ++j)
		{
			/*
			  Αρχικοποίηση του τελικού πίνακα C και εισαγωγή των στοίχειων από το χρήστη.
		      Ο χρήστης δήνει ολο τον πίνακα αλλά αποθηκεύονται μόνο τα μη μηδενικά στοιχεία
		      στη μεταβλητή a.Δεν χρησιμοποιήθηκαν πίνακες για εξοικονόμηση χώρου.
			*/
			c[i][j] = 0;
			scanf("%d", &a);

			/*
			  Ελέγχει αν ο αριθμός που εισάγει ο χρήστης είναι διάφορος του μηδενός. Στην 
			  συγκεκριμένη περίπτωση η μεταβλητή f λειτουργεί σαν flag.Στην πρώτη επανάληψη,
			  όταν το f ισούται με 1,η συνθηκη της else γινεται αληθής και δημιουργείται 
			  ο πρώτος κομβος της λιστας (head). Στις επόμενες επαναλήψεις που η f ειναι 0
			  περνάμε στην συνάρτηση push τα απαραίτητα στοιχεία για τον επόμενο κόμβο.
			*/
			if (a!=0)
			{
				if(f==0)
				{
					push(head, a, i, j);
				}
				else
				{
	                head->val = a;
	                head->col = i;
	                head->row = j;
	                head->next=NULL;
	                f = 0;
				}
			}

		}
	}

	//Η f ξαναγίνεται 1 για την εισαγωγη των στοιχειων του 'πίνακα Β 
    f = 1;
	node_t * head2 = malloc(sizeof(node_t));
	
	printf("Please input matrix B: \n");
	for (int i = 0; i <h; ++i)
	{
		for(int j=0; j<w; ++j)
		{
			scanf("%d", &a);
			if (a!=0)
			{
				if(f==0)
				{
					push(head2, a, i, j);
				}
				else
				{
	                head2->val=a;
	                head2->col = i;
	                head2->row = j;
	                head2->next=NULL;
	                f = 0;
				}
			}
		}
	}
	
	node_t * current = head;
    node_t * current2 = head2;
    //Δήλωση των μεταβλητών
    int col, row, val;
    /*
      Η while ελέγχει τον κάθε κόμβο αν είναι άδειος και αν δεν ειναι συνεχίζει
      Εισάγει τη στήλη, τη σειρά και το μη μηδενικό στοιχείο στους ακεραίους col, row, val αντίστοιχα 
      Χρησιμοποιεί τη στήλη και την σειρά για να εισάγει το στοιχείο στο σωστό κελί του πίνακα.
      Γίνεται η πρόσθεση ώστε όταν ξαναγίνει η ίδια διαδικασία  (2η while) για την δεύτερη λίστα να μπορούν 
      να προστεθούν τα στοιχεία στα σωστά κελιά του πίνακα.
    */
    while (current != NULL) 
    {
    	col = current->col;
    	row = current->row;
    	val = current->val;

    	c[col][row] = c[col][row] + val;
		current = current->next;
	}

	while (current2 != NULL) 
    {
    	col = current2->col;
    	row = current2->row;
    	val = current2->val;;

    	c[col][row] = c[col][row] + val;
		current2 = current2->next;
	}
	
	//Εκτυπώνει τον τελικό πίνακα C
    printf("------------------------------------\n" );    
    for (int i = 0; i < h; ++i)
    {
    	for (int j = 0; j < w; ++j)
    	{
    		printf("%d %s",c[i][j]," |" );	
    	}
    	printf("\n");
    }

}

/*
  Η συνάρτηση push δέχεται τον πρώτο κόμβο (την κεφαλή της διασυνδεδεμένης λίστας) το μη μηδενικό στοιχείο, την γραμμή και στήλη του στοιχείου
  , δημιουργεί και προσθέτει νέο κόμβο
  */
int push(node_t * head, int val, int i, int j) 
{
    node_t * current = head;
    /*
      Ελέγχει τον κέθε κόμβο αν ο pointer που περιέχει είναι διάφορος NULL. Όταν 
      βρει τον κόμβο που περιέχει pointer ίσο με NULL τερματίζει τη while.
	*/
    while (current->next != NULL) 
    {
        current = current->next;
    }
    //Δημιουργεί τον νέο κόμβο
    current->next = malloc(sizeof(node_t));
    current->next->val = val;
    current->next->col = i;
    current->next->row = j;
    current->next->next = NULL;
    return 0;  
}