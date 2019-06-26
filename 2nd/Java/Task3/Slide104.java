/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
public class Slide104
{
    double pi;

    // Constructor with a parameter
    public Slide104(double pi)
    {
        //The this keyword refers to the current object in a method or constructor.
        this.pi = pi;
    }

    // Call the constructor
    public static void main(String[] args)
    {
        Slide104 obj = new Slide104(3.14159);
        System.out.println("pi  = " + obj.pi);
    }
} 