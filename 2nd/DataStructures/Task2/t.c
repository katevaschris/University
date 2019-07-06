#include<stdio.h> 
#include<stdlib.h> 

struct node
{
	char key[3];
	struct node* left, * right;
};

struct node* newNode(char item[])
{
	struct node* temp = (struct node*)malloc(sizeof(struct node));
	temp->key = item;
	temp->left = temp->right = NULL;
	return temp;
}
void inorder(struct node* root)
{
	if (root != NULL)
	{
		inorder(root->left);
		printf("%d \n", root->key);
		inorder(root->right);
	}
}

struct node* insert(struct node* node, char key[])
{
	if (node == NULL) return newNode(key);

	if (key < node->key)
		node->left = insert(node->left, key);
	else if (key > node->key)
		node->right = insert(node->right, key);

	return node;
}

int main()
{
	char name[3];
	gets(name);
	struct node* root = NULL;
	root = insert(root, name);
	gets(name);
	insert(root, name);
	gets(name);
	insert(root, name);


	inorder(root);

	return 0;
}
