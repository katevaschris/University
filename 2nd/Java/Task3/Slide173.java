/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
class Parent 
{ 
    //Method show is going to be overriden!
    void show() 
    { 
        System.out.println("I am a function, that is going to be overriden! Also i got no parameters!"); 
    } 
} 
  
class Child extends Parent 
{ 
    @Override
    void show() 
    {   
        System.out.println("I override!"); 
    } 
} 
  
// Driver class 
class Slide173
{ 
    public static void main(String[] args) 
    { 
        //Creting objects from the above classes
        //Use those objects to call methods
        Parent obj = new Parent(); 
        obj.show(); 
        Parent obj2 = new Child(); 
        obj2.show(); 
    } 
} 