#include <stdio.h>

int main()
{
	int X[16] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	int H[8] = {0,1,2,3,4,5,6,7};
	int Y[16];
	int p;
	for(int j = 0; j < 8; ++j)
	{
		p = 0;
		for(int i = 0; i < 8; ++i)
		{
			p = p + H[i] * X[i+j];
		}
		Y[j] = p;
		printf("%d \n", Y[j]);
	}
	
	
	return 0;
}