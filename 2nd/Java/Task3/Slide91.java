/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
class Slide91
{
	int a;
	String b;
	static String v = "Stifler's...";
	//Method's vars 
	void Pr(int a, String b)
	{
		//i. (in for loop) is a local variable inside the method
		for (int i = 0; i < a; i++)
		{
			System.out.println(a);
			System.out.println(b);
		}
	}
	public static void main(String[] args)
	{
		Slide91 x = new Slide91();
		//Instance variables
		x.a = 10;
		x.b = "Chris";
		//Method is going to be called
		x.Pr(x.a, x.b);
		System.out.println(x.v);
	}
}