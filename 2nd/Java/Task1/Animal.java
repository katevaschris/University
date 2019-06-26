/*
        Main Author: Katevas Chris
	p18068
	github: https://github.com/katevaschris
	
	Athens 2, April 2018
	
	Main purpose: Address Book
*/
package unipi.katevas;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
public class AddressBook 
{/*
    static void Search(int phone)
    {   
        int i = 0;
        do
        {
            if(phone==phone[i])
            {
                
            }
        }while(flag);
        retrun ;  
    }
   */ 
    ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList for Names
    ArrayList<Integer> phones = new ArrayList<Integer>(); // Create an ArrayList for Phones
    ArrayList<String> emails = new ArrayList<String>(); // Create an ArrayList for E-mails
    ArrayList<String> addresses = new ArrayList<String>(); // Create an ArrayList for Pddresses
    ArrayList<String> planets = new ArrayList<String>(); // Create an ArrayList for Planet
    
    
    public static void main(String[] args)
    {
        System.out.println("Address Book application.");
        LocalTime myObj = LocalTime.now();
        System.out.println("Time: "+myObj);
        System.out.println("Please ress one from the following numbers to: ");
        System.out.println("1: Show all contacts");
        System.out.println("2: Add a new contact");
        System.out.println("3: Search a contact by name");
        System.out.println("4: Search a contact by phone");
        System.out.println("5: Change a contct by name");
        System.out.println("6: Delete a contact by name");
        System.out.println("0: Exit");
        // Create a Scanner object
        Scanner Object = new Scanner(System.in);
        //Create integer answer
        int answer = Object.nextInt();
        //Check what the user answered
        switch (answer) 
        {
            case 1:
              
              
              break;
            case 2:
              System.out.println("Tuesday");
              break;
            case 3:
              System.out.println("Wednesday");
              break;
            case 4:
              System.out.println("Thursday");
              break;
            case 5:
              System.out.println("Friday");
              break;
            case 6:
              System.out.println("Please Inser the name for deletion");
                
              break;
            case 0:
              System.exit(0); //In case you want to exit the app press: 7
              break;
            default:
                System.out.println("You gave wrong answer. Please try again: ");
                do
                {
                   answer = Object.nextInt();
                }
                while((answer<=0) && (answer>7));
            
          }
        
        
        /*
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input
        */
        
        
        System.out.println("Input name: ");
        // Input name
        String name = Object.nextLine();
        // Input phone number
        int phone = Object.nextInt();
  
        
    }
    
}
