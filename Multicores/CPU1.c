#include <stdio.h>
#include "platform.h"
#include "xil_printf.h"
#include <sleep.h>
#include "xil_exception.h"
#include "xil_cache.h"
#include "xscutimer.h"
#define mutexx (*(volatile unsigned long *)(0xFFFF0000))
#define ctr (*(volatile unsigned int*)(0xFFFF0004))

int main()
{
    init_platform();
    Xil_SetTlbAttributes(0xFFFF0000,0x14de2);
    print("CPU_1: init_platform\n\r");
    while(1)
    {
    	while(mutexx == 0){};
    	ctr += 2;
   	//reset the mutex- unlock sources
    	mutexx = 0;
    }
    cleanup_platform();
    return 0;
}
