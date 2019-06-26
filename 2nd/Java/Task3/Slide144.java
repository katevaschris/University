/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/

public class Slide144
{
	public static void main(String[] args)
    {
        //Int day, used in switch
        int day = 4;
        //Print out the day
        switch (day) 
        {  
            case(0):
                System.out.println("Monday"); 
                break;
            case(1):
                System.out.println("Tuesday"); 
                break;
            case(2):
                System.out.println("Wednesday");
                break; 
            case(3):
                 System.out.println("Thursday"); 
                 break;
            case(4):
                System.out.println("Friday"); 
                break;
            case(5):
                System.out.println("Saturday");
                break;  
            case(6):
                System.out.println("Sunday"); 
                break;
        }
        //Just a test with if_else!
        if(day == 1)
        {
            System.out.println("I am If...");
        }
        else
        {
           System.out.println("I am else!!!"); 
        }
    }
}