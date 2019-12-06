#include<stdio.h>
#include<stdbool.h>
bool check(int countx, int county)
{
	if(countx > county)
	{
		printf("No \n");
		return true;
	}
	else
	{
		return false;
	}
}

