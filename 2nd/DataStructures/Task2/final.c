#include<stdio.h> 
#include<stdlib.h> 
#include<stdbool.h>
   
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

    if (node == NULL)
    {
        return newNode(key); 
    }
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


//------------------------

struct node * minValueNode(struct node* node) 
{ 
    struct node* current = node; 
  
    /* loop down to find the leftmost leaf */
    while (current && current->left != NULL) 
        current = current->left; 
  
    return current; 
} 
  
struct node* deleteNode(struct node* root, char *key[]) 
{ 
    if (root == NULL)
    {
        return root; 
    }
    
    int ret = strcmp(key, root->key);
    if (ret < 0) 
    {
        root->left = deleteNode(root->left, key); 
    }
    else if (ret > 0 ) 
    {
        root->right = deleteNode(root->right, key); 
    }
    else
    { 
        // node with only one child or no child 
        if (root->left == NULL) 
        { 
            struct node *temp = root->right; 
            free(root); 
            return temp; 
        } 
        else if (root->right == NULL) 
        { 
            struct node *temp = root->left; 
            free(root); 
            return temp; 
        } 
  
        // node with two children: Get the inorder successor (smallest 
        // in the right subtree) 
        struct node* temp = minValueNode(root->right); 
  
        // Copy the inorder successor's content to this node 
        strcpy(root->key, temp->key); 

        // Delete the inorder successor 
        root->right = deleteNode(root->right, temp->key); 
    } 
    return root; 
} 




//------------------------
int main() 
{ 
    struct node *root = NULL; 
    root = insert(root, "gravity"); 
    insert(root, "mother"); 
    insert(root, "mirror");
    insert(root, "baaap");
    char word[255];
    
    while(true)
    {
        printf("Choose one from the following actions: \n 1:Insert element \n 2:Delete element \n 3:Search element \n 0:Exit system: ");
        int ans = 0;
        scanf("%d", &ans);
        switch (ans)
        {
            case 1:
                printf("Please insert(creates new node) a word (Use only characters): ");
                scanf("%s", word);
                insert(root, word);
                inorder(root);
                break;
            case 2:
                printf("Please delete(deletes a node) a word (Use only characters): ");
                scanf("%s", word);
                deleteNode(root, word);
                inorder(root); 
                break;

            
            case 3:

                break;

            
            default:
                exit(EXIT_SUCCESS);
                break;
        }
    }
    inorder(root); 
   
    return 0; 
} 
