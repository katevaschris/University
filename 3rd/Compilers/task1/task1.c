#include<stdio.h>
#include<stdbool.h>
#include"check.h"
#define length 256

void main()
{
	int i = 0;
	int countx = 0;
	int county = 0;
	char array[length];
	printf("Input String:  ");
	scanf("%s", array);
	printf("Given Array: %s \n", array);

	while(array[i]!= '\0')
	{
		if(array[i] == 'y')
		{
			county++;
			if(check(countx, county))
			{
				//y must be bigger
				break;
			}

		}
		else if(array[i] == 'x')
		{
			countx++;
			if(check(countx, county))
			{
				//y must be bigger
				break;
			}
		}
		else
		{
			printf("Wrong Character! \n");
			break;
		}
		i++;
	}
	if(county > countx)
	{
		printf("Yes \n");
	}
}
