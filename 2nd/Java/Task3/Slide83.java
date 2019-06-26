/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//No need for abstract interface
abstract interface Inter1
{
    public void Pr2();
}

//Abstact class
abstract class Demo implements Inter1
{
    //Abstract method
    abstract void Pr();
    //Non Abstract method
    public void Pr2()
    {
        System.out.println("I am a method inside of an abstract class!");
    }
}
class Test extends Demo
{
    //For abstract method
   void Pr()
    {
        System.out.println("I am a method inside a class.");
    } 
}
//Main class
class Slide83 
{
    //Calling abstract and non abstarct methods
    public static void main(String[] args)
    {
        Test obj = new Test();
        obj.Pr();
        obj.Pr2();
    }
} 