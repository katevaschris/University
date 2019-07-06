#include<stdio.h>
#include <stdlib.h>

typedef struct node
{

	char let;
	struct node* right;
	struct node* left;

	struct node* allw;

} node_t;



int main()
{
	

	node_t* root = malloc(sizeof(node_t));
	root -> let = 'b';
	root->right = NULL;
	root->left = NULL;
	char c;
	scanf("%c", &c);
	int x= ssearch(root, c);
	printf("%d", x);
	
/*
	scanf("%c", &c);
	push(root, c);
	x = ssearch(root, c);
	printf("%d", x);
*/
return 0;

	
	
}


int ssearch(node_t* root, char *c)
{
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
	printf("%c",current->let);
	if (c == current->let)
	{
		//not
		return 1;
	}
	else
	{
		//exists
		return 0;
	}

}
/*
int push(node_t* root, char *c)
{
	node_t* current = root;
	while ( (current->left != NULL) || (current->right != NULL)  )
	{
		if (c < current->let)
		{
			current = current->left;
			if (current->left == NULL)
			{
				current->left = malloc(sizeof(node_t));
				current->left->let = c;
				current->left->right = NULL;
				current->left->left = NULL;
			}
		}
		else if (c > current->let)
		{
			current = current->right;
			if (current->right == NULL)
			{
				current->right = malloc(sizeof(node_t));
				current->right->let = c;
				current->right->right = NULL;
				current->right->left = NULL;
			}
		}
	}
}
*/
