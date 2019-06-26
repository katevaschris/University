/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//This class is going to be extended!
class Demo
{
	//method 5*
	public void Pr()
	{
		System.out.println("I am alive");
	}
	public static void main(String[] args)
	{
		Demo x = new Demo();
		x.Pr();
	}
}
//Child class gonna "change", parent class
class Slide190 extends Demo
{
	public static void main(String[] args)
	{
		//Extending Class Demo
		new Demo()
		{
			public void Pr()
			{
				System.out.println("Extending a class vol4");
			}
			//.Pr() is going to call method mentioned with "5*" 
		}.Pr();
	}
}