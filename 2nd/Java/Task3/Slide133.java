/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
import java.util.ArrayList;
class Slide133
{
    public static void main(String[] args)
    {
        //Creat an Array list
        ArrayList<String> Ds3 = new ArrayList<String>();
        Ds3.add("Lannisters");
        Ds3.add("Targaryen");        
        Ds3.add("Starks");
        Ds3.add("Mormont");
        Ds3.add("Tarth");
        Ds3.add("Greyjoy");
        Ds3.add("WhiteWalkers");
        Ds3.add("Baratheon");
        Ds3.add("Clegane");
        Ds3.add("BAelish");
        Ds3.add("Tyrell");
        String tmp;
        //Use for loop to edit, delete 
        for (int i = 0; i < 10; i++)
        {
            //use tmp to store current element
            tmp = Ds3.get(i);
            //Print the array
            System.out.println("First: " + Ds3); 
            //Remove current Array element!  
            Ds3.remove(i);
            //Print Array after remove function
            System.out.println("After Remove: " + Ds3);
            //Removed Element is going to be added at the end of the ArrayList
            Ds3.add(tmp);
            //Print the array again after the restore function
            System.out.println("Restore the element: " + Ds3);    
        }
        System.out.println(Ds3);    

    }
}