#include<stdio.h> 
#include<stdlib.h> 
#include<string.h>
struct node 
{ 
    char key[255]; 
    char gkey[255];
    struct node *left, *right; 
}; 



int main() 
{ 

    struct node *root = NULL;
    root = insert(root, "gravity", "βαρύτητα");
    insert(root, "closet", "ντουλάπα");
    insert(root, "mirror", "καθρεύτης");
    insert(root, "mother", "μητέρα");
    insert(root, "black", "μαύρος");
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
                ans = ssearch(root, word);
                break;
            inorder(root);
        }
    }
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
        //not exist
        return 1;
    }
    else
    {
        //exists
        return 0;
    }

}

   

struct node *newNode(char *item[255]) 
{ 
    struct node *temp =  (struct node *)malloc(sizeof(struct node)); 
    temp->key = item; 
    temp->left = temp->right = NULL; 
    return temp; 
} 
   
void inorder(struct node *root) 
{ 
    if (root != NULL) 
    { 
        inorder(root->left); 
        printf("%c \n", root->key); 
        inorder(root->right); 
    } 
} 
   
struct node* insert(struct node* node, char *key[255]) 
{ 
    if (node == NULL)
    {
        return newNode(key); 
    }
    char x [255] = node->key;
    int ret = strcmp(key, x);
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
