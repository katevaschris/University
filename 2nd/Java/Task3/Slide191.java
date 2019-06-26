/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//Interface forces class to creat and use method PrMessage
interface Demo1
{
    public void PrMessage();
}

public class Slide191
{

    public static void main(String[] args)
    {
        //Implementing an existing interface with new()
        new Demo1()
        {
            //Interface for method!
            public void PrMessage()
            {
                System.out.println("I am a Function forced to exist by an Interface!");
            }    
        }.PrMessage();
    }
}