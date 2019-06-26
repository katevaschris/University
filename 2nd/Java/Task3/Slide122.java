/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
class Slide122
{
	//Some strings!
	//Let's compare them and print some messages!
	String x = "crowbar";
	String x2 = "borealis";
	String x3 = "crowbar";
	String x4 = "Crowbar";

	static public void main(String[] args)
	{
		Slide122 a = new Slide122();
		Slide122 a2 = new Slide122();
		if ((a.x).equals(a2.x3))
		{
			//Use .equals for bit to bit comparison
			if (!((a.x).equals(a2.x2)))
			{
				System.out.println("It's borealis!!!");
			}
		}
		else
		{
			System.out.println("It's borealis!");
		}
		if (!((a.x)==(a.x4)))
		{
			System.out.println("Where is borealis?");
		}
	}

}