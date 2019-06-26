/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//Top class
public class Slide41
{
    //Inner class num1
    public class Class1
    {
        String t1 = "This comes from Class 1";
    }

    //Inner Class num2
    public class Class2
    {
        String t2 = "This comes from Class 2";
    }

    public static void main(String[] args)
    {
        //Print from Inner class num 2 first
        //Then from inner class num 1
        Slide41.Class2 Obj2 = new Class2();
        Slide41.Class1 Obj = new Class1();
        System.out.println(Obj2.t2);
        System.out.println(Obj.t1);
    }
}
