/*
        Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 12, April 2018
    
    Main purpose: Address Book
*/
package unipi.katevas;
import java.util.*;
import java.util.Scanner; //User's input
import java.time.LocalTime; //Print time
import java.io.File;  // Import the File class
import java.io.FileWriter; // To write on a file
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.lang.StringBuilder;

public class AddressBook
{
    //Functions
    
    
    //Function: Delete
    //Input a name and deletes contact
    static void Del(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        { Scanner txtscan = new Scanner(new File("contacts.txt"));
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            String name= oldString;
            while (line != null) 
            {
                String str = txtscan.nextLine();
                //System.out.println("fd"+line);
                if(!(str.contains(name)))
                {
                    oldContent = oldContent + line + System.lineSeparator();
                }
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            //oldContent="";
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    //Function: Search
    //Search into a txt file
    static void Search(String name)
    {
        File file = new File("contacs.txt");
        int flag=0;
        try 
        {
            Scanner txtscan = new Scanner(new File("contacts.txt"));
            while(txtscan.hasNextLine())
            {
                String str = txtscan.nextLine();
                if(str.contains(name))
                {
                    System.out.println(str);
                    flag=1;
                }
            }
            if (flag==0)
            {
                System.out.println("There is no such contact into the file");
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("No such file");
        }
    }
    

    //Function: CheckL (CheckLetter)
    //String needs to contain only Letters
    static String CheckL()
    {
        Scanner Object = new Scanner(System.in);
        String name;
        do
        {
            System.out.println("Please input your name: ");
            name = Object.nextLine();
            if (name.contains("[a-zA-Z]+") == false && name.length() > 2)
            {
                break;
            } 
        }
        while(true);
        return name;
    }
    
    //Function: CheckN (Check Number)
    //String needs to contain only Numbers
    static String CheckN()
    {
        Scanner Object = new Scanner(System.in);
        String name;
        do
        {
            System.out.println("Please input your phone: ");
            name = Object.nextLine();
            if (name.matches("[0-9]+") && name.length() > 2)
            {
                break;
            }
        }
        while(true);
        return name;
    }
    
    //Function: CheckV (Check Void)
    //String needs not to be void
    static String CheckV()
    {
       Scanner Object = new Scanner(System.in);
        String name;
        do
        {
            name = Object.nextLine();
            if (name!="")
            {
                break;
            }
        }
        while(true);
        return name; 
    }
    
    //Function: PrInfo
    //Prints info about a file
    static void PrInfo()
    {
        File myObj = new File("contacts.txt");
        System.out.println("File name: " + myObj.getName());
        System.out.println("Absolute path: " + myObj.getAbsolutePath());
        System.out.println("Writeable: " + myObj.canWrite());
        System.out.println("Readable: " + myObj.canRead());
        System.out.println("File size in bytes " + myObj.length());
        
    }
    
    //Function: FindW
    //Find Word of a given String without user's input
    static String FindW(String s, int type)
    {
        int count = 0;
        int i = 0;
        int end = 0;
        Boolean flag = true;
        String[] ar = s.split("");
        int start = 0;
        //System.out.println(Arrays.toString(ar));
        while((count < type+1) && (ar.length>i))
        {   
            if((ar[i].equals("|")) &&(count<=type+1))
            {
                count++;
                if((flag) && (count==type)) 
                {
                    start = i+1;
                    flag = false;
                }
                if(count==type+1)
                {
                    
                    end=i;
                    break;
                }
                
            }
            i++;
        }
        StringBuilder strBuilder = new StringBuilder();
        while(start+1 <end)
        {
           strBuilder.append(ar[i]);
           start++;
        }
        String word = strBuilder.toString();
        return word;
    }
    
    
    //Function: ModC( Modify Contact)
    //New input for a contact/ Default: based by name
    static void ModC(String filePath, String name)
    {
        File fileToBeModified = new File(filePath);
        BufferedReader reader = null;
        FileWriter writer = null;
        Scanner Object = new Scanner(System.in);
        String oldContent = "";
        String oldString = "";
        String newString = "";
        try
        { 
            Scanner txtscan = new Scanner(new File("contacts.txt"));
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            int flag = 0;
            //String name= oldString;
            String map = "";
            Boolean bol = true;

            while (line != null) 
            {
                String str = txtscan.nextLine();
                //System.out.println("fd"+line);
                if(str.contains(name))
                {
                    oldString = line;
                    System.out.println("Current Contact: "+ str);
                    while(bol)
                    {
                        System.out.println("What do you want to modify?");
                        System.out.println("1: Name");
                        System.out.println("2: Phone");
                        System.out.println("3: Email");
                        System.out.println("4: Address");
                        System.out.println("5: Planet");

                        try
                        {
                            do
                            {
                                flag = Object.nextInt();
                            }
                            while((flag<=0) && (flag>=3));
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("Watch out mate!");
                            System.exit(0);
                        }
                        switch(flag)
                        {
                            case 1:
                                System.out.println("Input New name");
                                map = CheckL();
                                line = line.replaceAll(name, map);
                                break;
                            case 2:
                                name = FindW(line, flag);
                                map = CheckN();
                                line = line.replaceAll(name, map);
                                break;
                            case 3:
                                System.out.println("Input New email");
                                name = FindW(line, flag);
                                map = CheckV();
                                line = line.replaceAll(name, map);
                                System.out.println("bouts"+line);
                                break;
                            case 4:
                                System.out.println("Input New address");
                                name = FindW( line, flag);
                                map = CheckV();
                                line = line.replaceAll(name, map);
                                break;
                            case 5:
                                System.out.println("Input New planett");
                                name = FindW(line, flag);
                                map = CheckV();
                                line = line.replaceAll(name, map);
                                break;
                            case 0:
                                bol = false;
                                break;
                            default:
                                System.out.println("Watch out mate!");
                                System.exit(0);
                        }
                        newString=line;
                    }
                }
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            //oldContent="";
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(oldContent);
            reader.close();
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Watch out mate!");
        }
    }
    
    
    
    public static void main(String[] args) 
    {
      
        //Check if the files exists or not
        try 
        {
            File myObj = new File("contacts.txt");
            if (myObj.createNewFile()) 
            {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter("contacts.txt");
                //Default contacts in case no such file exists
                myWriter.write("| Name | Phone Number | Email | Address | Planet |"+'\n');
                myWriter.write("| Name: ExampleOne | Phone: 123456 | Email: email@email.org | Address: Somewhere | Planet: Earth |"+'\n');
                //Closing the resources
                myWriter.close();
                PrInfo();
            } 
            else 
            {
                System.out.println("File contacts.txt already exists.");
                PrInfo();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        //There is an "infinite" loop in case user wants to do a lot of things
        //After one from the following functions is done, main menu is going to print again
        //Pressing 0(zero) ends everything
        
        while(true)
        {
            //Print main menu
            System.out.println("_____________________________________________________________");
            System.out.println("Address Book application.");
            LocalTime TimeObj = LocalTime.now();
            System.out.println("Time: "+TimeObj);
            System.out.println("1: Show all contacts");
            System.out.println("2: Add a new contact");
            System.out.println("3: Search a contact by name");
            System.out.println("4: Search a contact by phone");
            System.out.println("5: Change a contact by name");
            System.out.println("6: Delete a contact by name");
            System.out.println("0: Exit");
            System.out.println("Please press one from the above mentioned numbers: ");
           
            // Create a Scanner object
            //Create vars
            Scanner Object = new Scanner(System.in);
            int flag=0;
            String name;
            
            //Check what the user's input
            try
            {
                do
                {
                    name = Object.nextLine();
                    flag = Integer.parseInt(name);
                }
                while((flag<=0) && (flag>7));
            }
            catch(NumberFormatException e)
            {
                System.out.println("Watch out mate!");
                System.exit(0);
            }
       

            switch (flag) 
            {
                case 1:
                    //Print all contacts from txt file contacts.txt
                    try 
                    {
                        File myObj = new File("contacts.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) 
                        {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        //Closing the resources
                        myReader.close();
                    } 
                    catch (FileNotFoundException e) 
                    {
                        System.out.println("No such file");
                        e.printStackTrace();
                    } 

                    break;
                case 2:
                    try 
                    {
                        PrintWriter myWriter = new PrintWriter(new FileWriter("contacts.txt"  , true));
                        
                        //Input Name
                        name = CheckL();
                        myWriter.write("| Name: "+ name);
                        
                        //Input phone number
                        name = CheckN();
                        myWriter.write(" | Phone: "+name);
                        
                        //Input Email Address
                        System.out.println("Please input your email: ");
                        name = CheckV();
                        myWriter.write(" | Email: "+name);                    
                        
                        //Input Home Address
                        System.out.println("Please input your address: ");
                        name = CheckV();
                        myWriter.write(" | Address: "+name);
                        
                        //Input Planet
                        System.out.println("Please input your planet: ");
                        name = CheckV();
                        if (name!="Earth" || name!="earth") 
                        {
                          System.out.println("I want to believe!");
                        }
                        myWriter.write(" | Planet: "+name+" |"+'\n');

                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } 
                    catch (IOException e)
                    {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    
                    break;
                case 3:
                    System.out.println("Search by name. Please input name: ");
                    name = CheckL();
                    Search(name);

                    break;
                case 4:
                    System.out.println("Search by phone. Please input phone: ");
                    name = CheckN();
                    Search(name);

                    break;
                case 5:
                    name = CheckL(); 
                    ModC("contacts.txt",name);
                    System.out.println("Done");

                    break;
                case 6:
                    System.out.println("Delete by name. Please input name: ");
                    name = CheckL();
                    Del("contacts.txt", name,"");
                    
                    break;
                case 0:
                    //In case you want to exit the app press: 0 (zero)
                    System.exit(0);
                    
                    break;
                default:
                    System.out.println("Watch out mate!");
                    System.exit(0);
            }
        }
    }
}
