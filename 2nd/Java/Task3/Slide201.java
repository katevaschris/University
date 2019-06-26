/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
interface AnonClass
{
	String lyr = "Waiting for the sun";
	public void Pr();
}
class Slide201
{	
	public static void main(String[] args)
	{	
		//Anonymous class inside main!
		AnonClass x = new AnonClass()
		{
			public void Pr()
			{
				System.out.println(lyr);
			}
		};
		//x created by the anonymous class to call method Pr (located: inside anonymous class)
		x.Pr();
	}
}