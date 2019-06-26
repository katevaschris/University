/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
class Slide99
{
	//Method
	//Ints starting from 1 and ends to 5
	void Pr( String b, int... a)
	{
		//
		for (int i : a )
		{
			//Print out the arguments
			System.out.println(i);
			System.out.println(b + "\nI am a method with varargs");
		}
	}
	public static void main(String[] args)
	{
		//Create object
		Slide99 obj = new Slide99();
		//Use obbject to call the function
		obj.Pr("then I took an arrow to the knee", 1, 2, 3, 4, 5);
	}
}