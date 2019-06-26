/*
	Contribution (Algorithm Designer): Pakou Eva
	p18118
	github: https://github.com/Evaggelia18
	
	Main Author: Katevas Chris
	p18068
	github: https://github.com/katevaschris
	
	Athens 2, April 2018
	
	Main purpose: Find and print an eulerian trail
*/
#include <stdio.h>

int main(void)
{
	int n;
	printf("Give number: ");
	scanf("%d", &n);
	int l[n][n];
	//Default values
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			//major cross line default value set to 7
			if (i==j)
			{
				l[i][j]=7;
			}
			else
			{
				l[i][j]=0;
			}
		}
	}

	//Define how many connections(loops)
	unsigned long long int ncon = n*(n-1)/2;
	printf("%llu\n",ncon );
	

	//The fun part
	int i = 1;
	int j = 0;
	//last i 
	int li = 0;
	int eva = 0;

	printf("\n");
	printf("\n");

	for (int sum = 0; sum < ncon; ++sum)
	{
		if (l[i][j]==0)
		{
			l[i][j]=1;
			l[j][i]=1;
			printf("%d", j+1);
		 	//i points j and i equals zero, new line
			li = j;
			j=i; 
			i=0;
			
			//In case we are in final raw we need to check for remeaning elements
			//Case we got no elements, i equals to zero (return 0)
			//Case we don't we need to i++ for next elements in last raw
			if (((j==n-1) && (i==0)) && (eva ==0))
			{
				if (l[li+1][n-1]!=7)
				{
					i=li+1;
					eva=0;
				}
				else
				{
					eva=1;
				}
			}
			
				
			//find next element equals zero
			for (int g = 0; g < n; ++g)
			{
				if ((l[i][j]==1) || (l[i][j]==7))
				{
					i=i+1;
				}
			}	
		}
		printf("%s", " -> ");	
			
	}
	//add 1 as final element of the trail
	printf("%d\n", 1);

	printf("\n");
	//print table
	for(int i = 0; i < n; i++)
	{
    	for(int j = 0; j < n; j++)
    	{
        	printf("%d ", l[i][j]);
    	}
    	printf("\n");
    }
	return 0;

}