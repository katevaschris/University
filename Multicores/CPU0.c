#include <stdio.h>
#include "platform.h"
#include "xil_printf.h"
#include <sleep.h> 
#include "xscutimer.h"
#include "xil_cache.h"

#define mutexx (*(volatile unsigned long *)(0xFFFF0000))
#define ctr (*(volatile unsigned int*)(0xFFFF0004))
#define cutdown (*(volatile unsigned int*)(0xFFFF0008))
#define ONE_SEC 333500000 // 1 second
#define howmanysecs 2
#define Status (*(volatile unsigned int*)(0xFFFF0008))

XScuTimer Timer;

int main()
{
	init_platform();
	print("CPU_1: init_platform\n\r");
    	mutexx = 0;
    	ctr = 0;
    	cutdown = 0;
    	Xil_SetTlbAttributes(0xFFFF0000,0x14de2);
	XScuTimer_Config *ConfigPtr;
	XScuTimer *TimerInstancePtr;
	ConfigPtr = XScuTimer_LookupConfig(XPAR_PS7_SCUTIMER_0_DEVICE_ID);
    	Status = XScuTimer_CfgInitialize(TimerInstancePtr,ConfigPtr,ConfigPtr -> BaseAddr);
    	if (Status != XST_SUCCESS)
    	{
		print("Timer init() failed \n\r");
		return XST_FAILURE;
	}

	XScuTimer_LoadTimer(TimerInstancePtr,ONE_SEC*howmanysecs);
	XScuTimer_EnableAutoReload(TimerInstancePtr); // Loop the cutdown timer
	XScuTimer_Start(TimerInstancePtr);
	printf("Current count is : %d\n", ctr);

   	while(1)
    	{
    		if (XScuTimer_IsExpired(TimerInstancePtr))
    		{
			XScuTimer_ClearInterruptStatus(TimerInstancePtr);
			print("CPU_0: init_platform\n\r");
			if (cutdown  == 5 )
			{
				ctr += 1;
				cutdown = 0;
			}
			else 
			{
				mutexx = 1;
				while(mutexx == 1);
				cutdown += 1;
			}
			printf("Current count is : %d\n", ctr);
    		}
    	}
    	cleanup_platform();
   	return 0;
}
