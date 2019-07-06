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
#include<string.h>
#include <stdbool.h>

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
} node_t;



void main()
{
	printf("Welcome to our search Tree! \n Binary search tree is empty! \n If you want to perform all possible actions, first you must insert elements! \n Enjoy! \n");
	
	//Δέσμευση χώρου για την υλοποίση ενός κόμβου από το struct node_t
	node_t* root = malloc(sizeof(node_t));
	bool f = true;

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
				
				if(!f)
				{
					//Χρησιμοποιούμε τη συνάρτηση search για να δούμε αν υπάρχει το πρώτο γράμμα της λέξης που δώθηκε
					search(root, word[0]);
				}
				else
				{
					root->let = word[0];
					root->right = NULL;
					root->left = NULL;
					f = false;
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


bool search(node_t* root, char c)
{
	node_t* current = root;

	return false;

	return true;

}


int push(node_t* root)
{
	node_t* current = root;
	while (current->next != NULL)
	{
		current = current->next;
	}
	//Δημιουργεί τον νέο κόμβο
	current->next = malloc(sizeof(node_t));
	current->next->val = val;
	current->next->next = NULL;
	return 0;
}

*/
