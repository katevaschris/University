/*
    Main purpose: Input String and new position and gonna print the new lexicography word
                    in givven rank
*/

//Same program like the other task but with one more if(given rank == current rank)


// Program to print all permutations of a string in sorted order. 
#include <stdio.h> 
#include <stdlib.h> 
#include <string.h> 
#include <stdbool.h>
//Functions
int compare(const void *a, const void * b) 
{
    return ( *(char *)a - *(char *)b );
} 
  
// Function for swap two chars
// Use pointers return nothing
void swap(char* a, char* b) 
{ 
    char t = *a; 
    *a = *b; 
    *b = t; 
} 
  
// Find the smallest char which is greater than current up until the end of the string 
int findn(char str[], char first, int l, int h) 
{  
    int c = l;
    //Scanning the string
    for (int i = l+1; i <= h; i++)
    { 
      if (str[i] > first && str[i] < str[c]) 
        {
            c = i; 
        }
    }
    return c; 
} 
  
//Function that print all possible sorted strings
void pr_all(char str[], int k) 
{ 
    //length of string 
    int length = strlen(str); 
    int counter = 0;
    // Sort the string in increasing order 
    qsort(str, length, sizeof( str[0] ), compare);  
    bool flag = false; 
    while ( !flag ) 
    {
        //Print Rank and String
        if(counter == k)
        {
            printf("%s %d\n","Rank: ",counter );
            printf ("%s \n", str);
            break;
        }
        counter++; 
        // Find the rightmost char which is smaller than its next one
        int i; 
        //Go backwards
        for(i = length - 2; i >= 0; --i)
        {
           if(str[i] < str[i+1]) 
            {
                break; 
            }
        }
        //Break
        if(i == -1)
        { 
            flag = true; 
        }
        else
        {
            int c = findn( str, str[i], i + 1, length - 1 );
            //Swap
            swap( &str[i], &str[c] ); 
            //An now sorting time
            qsort(str + i + 1, length - i - 1, sizeof(str[0]), compare); 
        } 
    } 
} 
  
//Main program
int main() 
{ 
    printf("Please input binary number: ");
    char str[256];
    scanf("%s", str); 
    int k;
    printf("Please input the new position: ");
    scanf("%d", &k);

    pr_all(str, k); 
    return 0; 
} 
