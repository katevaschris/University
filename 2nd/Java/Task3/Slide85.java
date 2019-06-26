/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
//Final class we can not extend this class
final class Slide85 
{
	//Can't change value for String b
	final String b = "I am a Goofy Goober!";
	//Can't @overide this method
	final void Pr(String b)
	{
		System.out.println(b);
	}

	public static void main(String[] args)
	{
		Slide85 x = new Slide85();
		x.Pr(x.b);
	}
}