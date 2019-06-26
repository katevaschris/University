public class Slide110
{ 
  
    // Overloaded sum(). This sum takes no parameters 
    public int sum() 
    { 
        System.out.println("And Gandalf the Grey said: Fly, you fools!");
        return 0; 
    } 
  
    // Overloaded sum(). This sum takes three int parameters 
    public double sum(double p, double a, double i) 
    { 
        return (p + a + i); 
    } 
  
    // Overloaded sum(). This sum takes two double parameters 
    public double sum(double p, double i) 
    { 
        return (p + i); 
    } 
    
    //Main method, methods are going to be called here
    public static void main(String args[]) 
    { 
        Slide110 pi = new Slide110(); 
        //method some with no parameters
        System.out.println(pi.sum()); 
        //Method sum with 3 parameters
        System.out.println(pi.sum(0.14159, 1.0, 2.0));
        //method sum with no parameters 
        System.out.println(pi.sum(2.14159, 1.0)); 
    } 
} 