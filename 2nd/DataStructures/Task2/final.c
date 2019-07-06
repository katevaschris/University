#include<stdio.h> 
#include<stdlib.h> 
   
struct node 
{ 
    char key[255]; 
    struct node *left, *right; 
}; 
   

struct node *newNode(char *item[]) 
{ 
    struct node *temp =  (struct node *)malloc(sizeof(struct node)); 
    strcpy(temp->key,item); 
    temp->left = temp->right = NULL; 
    return temp; 
} 
   

void inorder(struct node *root) 
{ 
    if (root != NULL) 
    { 
        inorder(root->left); 
        printf("%s \n", root->key); 
        inorder(root->right); 
    } 
} 
   

struct node* insert(struct node* node, char *key[]) 
{ 

    if (node == NULL) return newNode(key); 
    
    int ret = strcmp(key, node->key);
    if (ret < 0) 
    {
        node->left  = insert(node->left, key); 
    }
    else if (ret > 0)
    {
        node->right = insert(node->right, key);    
    }
    else
    {
        printf("String already exists");
    }
    
    return node; 
} 
    
int main() 
{ 
    struct node *root = NULL; 
    root = insert(root, "gravity"); 
    insert(root, "mother"); 
    insert(root, "mirror");
    insert(root, "baaap");
   
    inorder(root); 
   
    return 0; 
} 
