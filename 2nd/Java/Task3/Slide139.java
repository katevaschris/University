/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
public class Slide139
{
    public static void main(String[] args)
    {
        double pi = 3.14159;
        double b = 3.141592;
        //Ternary operator!
        /* if(pi>b)
            {
                pi = pi;
            }
            else
            {
                pi = b;
            }
        */
        pi = (pi > b)? pi : b;
        //Print out final value of var pi
        System.out.println(pi);
    }
}