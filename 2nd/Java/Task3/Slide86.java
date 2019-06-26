/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//Interfaces are already "static"
interface Inter1
{
	//Static var
	static String r = "Pickle Rick!";
}
class Slide86 implements Inter1
{

	//Static method
	static void Pr()
	{
		System.out.println("Pickle Rick!");		
	}
	//Static inner class like main!!!
	public static void main(String[] args)
	{
		System.out.println(r);
		Slide86 x = new Slide86();
		x.Pr();
	}
}