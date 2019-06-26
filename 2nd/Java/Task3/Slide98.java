/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
class Slide98
{
	//Just a simple method with return statment
	String Lie()
	{
		String cake = "The cake is a lie! The cake is a lie! The cake is a lie!";
		return cake;
	}

	public static void main(String[] args)
	{
		//Creating an object
		Slide98 RattMann = new Slide98();
		//getting return value into a string var
		//Calling method via the object
		String Newell3 = RattMann.Lie();
		//Printing the above-created string
		System.out.println(Newell3);
	}
}