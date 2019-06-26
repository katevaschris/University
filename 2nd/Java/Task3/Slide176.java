/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
interface Inter1
{
	//A var from a String
	public void Pr(String x);
	final String p = "Praise the sun!";
}

public class Slide176 implements Inter1
{

	//Var created by that class!
	String a = "Praise the sun!";
	public void Pr(String x)
	{
		System.out.println(x);
	}
	public static void main(String[] args)
	{
		Slide176 x = new Slide176();
		x.Pr(x.a);
		System.out.println(p+"!");
		//Using a var from class object
		Object o = new Slide176();

	}
}

class Demo extends Slide176 implements Inter1
{
	//Var created from parent-class
	@Override
	public void Pr(String x)
	{
		System.out.println(x);
	}
	public static void main(String[] args)
	{
		Demo h = new Demo();
		h.Pr(h.a+"!!!!");
		System.out.println(p);


	}

}