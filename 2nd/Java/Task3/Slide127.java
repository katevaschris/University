/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
import java.util.ArrayList;
class Slide127
{
    public static void main(String[] args) 
    {
        //Creating an Array list
        ArrayList<String> Ds3 = new ArrayList<String>();
        Ds3.add("NameLess King");
        Ds3.add("Abyss Watchers");
        Ds3.add("Pontiff Sulyvahn");
        System.out.println(Ds3);
        Ds3.remove(1);
        System.out.println(Ds3);
        Ds3.set(1, "Dancer of the Boreal Valley");
        //Print the array list!
        System.out.println(Ds3);


    }
}