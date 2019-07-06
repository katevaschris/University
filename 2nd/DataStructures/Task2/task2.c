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
#include "windows.h"
#include <string>

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
	/*
		Αν η search είναι επιστρέφει true τότε το γράμμα δεν υπάρχει
		αλλιώς επιστρέφει false και το γράμμα υπάρχει
	*/
	node_t* current = root;
	while ( (c != current->let) && ( (current->left != NULL) && (current->right != NULL) )  )
	{
		if (c < current->let)
		{
			current = current->left;
		}
		else if(c > current->let)
		{
			current = current->right;
		}
	}
	if ((c != current->let) && ((current->left != NULL) && (current->right != NULL)))
	{
		return true;
	}
	else
	{
		return false;
	}

}


int push(node_t* root, char c, char word[] )
{
	/*
		Ψάχνω να βρω που θα τοποθετηθεί ο νέος κόμβος (ξέρω ότι δεν υπάρχει)
	*/
	node_t* current = root;
	while ( (current->left != NULL) && (current->right != NULL)  )
	{
		if (c < current->let)
		{
			current = current->left;
		}
		else if (c > current->let)
		{
			current = current->right;
		}
	}
	current->next = malloc(sizeof(node_t));
}
