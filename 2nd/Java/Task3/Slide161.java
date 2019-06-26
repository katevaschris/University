/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//Parent class
class Slide161
{
    String brand = "Suzuki";
    //Method to print
    public void prname() 
    {
        System.out.println(brand);
     }
}

//Child Class num 1
class Car extends Slide161
{
    //Uses parent's method prname to print model
    String modelName = "Vitara"; 
    public static void main(String[] args) 
    {
        Car myCar = new Car();
        myCar.prname();
        System.out.println(myCar.brand + myCar.modelName);
    }
} 



class Car2 extends Slide161
{
    String modelName = "Samurai";
    //Got an extra element, an int
    Integer carnum = 99; 

    public static void main(String[] args) 
    {
        Car2 myCar2 = new Car2();
        //Uses parent's method(Class Slide161) to print elemtns
        myCar2.prname();
        System.out.println(myCar2.brand + myCar2.modelName);
        System.out.println(myCar2.carnum);
    }
} 