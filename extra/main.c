#pragma warning( disable : 4996)
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

typedef struct node
{
	int var;

	struct node* left;
	struct node* right;
}node_t;

int main()
{
	printf("Input :\n ");
	int x;
	scanf("%d", &x);

	node_t* root = malloc(sizeof(node_t));
	root->var = 10;
	root->right = NULL;
	root->left = malloc(sizeof(node_t));
	root->left->var = 5;


	printf("%d %d", root->var, root->left->var);
	return 0;
}

int push(node_t* root, int x)
{
	node_t* current = root;
	if (check_left(root, x))
	{

	}
	else if (check_right(root, x))
	{

	}
}

bool check_left(node_t* root, int x)
{
	if (x < root->left)
	{
		return true;
	}
	return false;
}

bool check_right(node_t* root, int x)
{
	if (x >= root->right)
	{
		return true;
	}
	return false;
}