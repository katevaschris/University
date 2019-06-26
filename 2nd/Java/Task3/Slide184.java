 /*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
public class Slide184 
{
    //Create Int d
    public class C1
    {
        Integer d = 3;
    }
    //Cast Int d as an object!
    //From obj to obj2
    public class C2 extends C1
    {
        Slide184.C2 obj = new Slide184.C1();
        Slide184.C1 obj2 = (Slide184.C2) obj;
    }
    //Use int a and convert it to double b
    //And backwards! Finally print them out!
    public static void main(String[] args) 
    {
        System.out.println("Widening Casting: Convert int to double. ");
        int a = 3;
        //Convert int ot foat
        double b = a;
        System.out.println(a);
        System.out.println(b);   

        System.out.println("Narrowing Casting: Conver double to int.");
        a = (int) b;
        System.out.println(b);
        System.out.println(a);

    }

}