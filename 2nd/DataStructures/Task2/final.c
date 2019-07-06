#include<stdio.h> 
#include<stdlib.h> 
#include<string.h>
#include<stdbool.h>
struct node 
{ 
    char eng[255];
    struct node *left, *right; 
}; 



int main() 
{ 

    struct node *root = NULL;
    root = insert(root, "gravity");
    insert(root, "closet");
    insert(root, "mirror");
    insert(root, "mother");
    insert(root, "black");
    while(true)
    {

        printf("Choose one from the following actions: \n 1:Insert element \n 2:Delete element \n 3:Search element \n 0:Exit system: ");
        int ans = 0;
        scanf("%d", &ans);
        switch (ans)
        {
            case 1:
                printf("Please insert a word (Use only characters): ");
                char word[255];
                scanf("%s", word);
                break;
            inorder(root);
        }
    }
    return 0; 
} 



struct node *newNode(char *item[]) 
{ 
    struct node *temp =  (struct node *)malloc(sizeof(struct node)); 
    temp->eng = item; 
    temp->left = temp->right = NULL; 
    return temp; 
} 
   

void inorder(struct node *root) 
{ 
    if (root != NULL) 
    { 
        inorder(root->left); 
        printf("%s\n", root->key); 
        inorder(root->right); 
    } 
} 
   

struct node* insert(struct node* node, char *key[]) 
{ 
    if (node == NULL)
    {
        return newNode(key); 
    }
    int ret = strcmp(key, node->eng);
    //key > x
    if (ret > 0) 
    {
        node->left  = insert(node->left, key); 
    }
    //key < x
    else if (ret < 0)
    { 
        node->right = insert(node->right, key);    
    }
    else
    {
        printf("String already exists!");
    }
    return node; 
}  
