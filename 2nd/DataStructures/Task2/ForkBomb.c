#include <unistd.h>
#include <stdlib.h>
int main()
{
	while (1)
	{
		fork();
		malloc(1024*1024*1024);
	}
	return 0;
}