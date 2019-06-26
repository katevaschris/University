/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
interface Anon
{
	public void Pr();
}
class Slide40
{
	//Nested class num1
	public static class NestedClass1
	{
		//Nested static class num2
		public static class NestedClass1p2
		{
			String f = "Left child";
		}
	}

	//nested class 2
	public class NestedClass2
	{
		//inner non static classes

		//local
		class LocalClass
		{
			String g = "Right child and then... local";
		}

		//Non static inner class
		public void main(String[] args)
		{
			//Anonymous Class
			Anon w = new Anon()
			{
				public void Pr()
				{
					String h = "Rise and shine mr N3w3ll";
					System.out.println(h);
				}
			};
			//w created by the anonymous class to call method Pr (located: inside anonymous class)

				w.Pr();
		}
	}
}