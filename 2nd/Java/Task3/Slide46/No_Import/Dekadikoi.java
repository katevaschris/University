/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//Akeraioi.java and  Dekadikoi.java are going to be found on the same dir
//Dekadikoi.java uses instance from Akeraioi.java
//print out "ena" variable
public class Dekadikoi
{
    public static void main(String[] args)
    {
        Akeraioi obj = new Akeraioi();
        System.out.println(obj.ena);
    }
}
