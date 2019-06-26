/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
class Slide124
{	
	static public void main(String[] args)
	{
		//Editing a string, creates a new one!
		//Ram full of garbage!
		String s = "When we edit a string, we creat a new one!... Too much space";
		System.out.println(s);
		s = s + "!!";
		System.out.println(s);
		//Instead we can use StringBuffer to edit the string!
		StringBuffer s2 = new StringBuffer("Use StringBuffer! Less space"); 
		System.out.println(s2);
		s2.append("!!");
		System.out.println(s2);
	}

}