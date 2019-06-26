/*
    Main Author: Katevas Chris
    p18068
    github: https://github.com/katevaschris
    
    Athens 21, May 2019
    
    Main purpose:
*/
class Slide88 
{
	//Static method, called by a non static method
	static int fun()
	{
		System.out.println("I am a static function! Called by a non static function!");
		return 0;
	}

	//Non static method
	int fun2()
	{
		System.out.println("I a non static function!");
		fun();
		return 0;
	}
	//Main
	//Non static method is going to be called from main
	public static void main(String[] args)
	{
		Slide88 obj = new Slide88();
		obj.fun2();
	}
}