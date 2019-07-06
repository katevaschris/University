/*
	Main Authors: Pakou Eva, Katevas Chris

	Pakou Eva
	p18118
	github: https://github.com/Evaggelia18

	Katevas Chris
	p18068
	github: https://github.com/katevaschris

	Athens 5, July 2019

	Main purpose:
*/

#include<stdio.h>
#include <stdlib.h>

typedef struct node
{
	//Μεταβλητή που περιέχει το γράμμα
	char let;
	/*
		Χρησιομοποιούνται 2 pointers για να καθορίσουν το επόμενο-"παιδί" του κόμβου
		Αν η τιμή του παιδιού-κόμβου είναι μικρότερη από την τιμή του γονέα-κόμβου τότε το χρησιμοποιείται ο αριστερός δείκτης
		Αντίθετα αν είναι μεγαλύτερη, χρησιμοποιείται ο δεξής δείκτης
	*/
	struct node* right;
	struct node* left;

	//Pointer που δείχνει στην αντίστοιχη λίστα με τις λέξεις που έχουν καταχωρηθεί και αρχίζουν από το γράμμα let
	struct node* allw;

} node_t;



void main()
{
	printf("Welcome to our search Tree! \n Binary search tree is empty! \n If you want to perform all possible actions, first you must insert elements! \n Enjoy! \n");
	
	//Δέσμευση χώρου για την υλοποίση ενός κόμβου από το struct node_t
	node_t* root = malloc(sizeof(node_t));
	
	//Το πρόγραμμα εκτελείται μέχρι ο χρήστης να επιλέξη ενέργεια με αριθμό διάφορο του 1, 2, 3. Έτσι το πρόγραμμα θα τερματίσει (Δες default στη switch)
	while (true)
	{
		printf("Choose one from the following actions: \n 1:Insert element \n 2:Delete element \n 3:Search element \n 0:Exit system: ");
		//Ορίζουμε προεπιλογή την έξοδο από το πρόγραμμα
		int ans = 0;
		//Ο χρήστης επιλέγει ποια από τις 4 ενέργεια θέλει να εκτελέσει
		scanf("%d", &ans);
		switch (ans)
		{
			case 1:
				/*
					Εισαγωγή στοιχείου
					Αν το γράμμα δεν έχει καταχωρηθεί στο δέντρο, δημιουργείται και μετά εισάγεται η λέξη
				*/
				printf("Please insert a word (Use only characters): ");
				char word[255];
				scanf("%s", word);
				/*
					Χρησιμοποιούμε τη συνάρτηση search για να δούμε αν υπάρχει το πρώτο γράμμα της λέξης που δώθηκε
					Αν υπάρχει το γράμμα τότε εκτελείται η else 
					Αν το γράμμα δεν υπάρχει εκτελείται η if
				*/
				if (search(root, word[0]))
				{
					//Χρησιμοποιείται η συνάρτηση push, για τη δημιουργεία νέου κόμβου (για τη δημιουργία νέου γράμματος στο δέντρο)
					push(root, word[0], word);
				}					
				else
				{
					//Χρησιμοποιείται η συνάρτηση insert για την εισαγωγή της νέας λέξης στο πίνακα
					insert(word);
				}
				break;

			
			case 2:
				//Διαγραφή στοιχείου
				break;

			
			case 3:
				//Αναζήτηση στοιχείου
				break;

			
			default:
				//Έξοδος από το σύστημα (με ειασγωγή οποιουδήποτε αριθμού
				exit(EXIT_SUCCESS);
				break;
		}
	}
}

