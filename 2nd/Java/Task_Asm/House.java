import acm.program.*;
import acm.graphics.*;

public class House extends GraphicsProgram
{
	public void run()
	{


		//tower_1
		add(rect(50, 300, 30, 200));
		add(line(50, 300, 65, 250));
		add(line(80, 300, 65, 250));

		//tower_2
		add(rect(180, 300, 30, 200));
		add(line(180, 300, 195, 250));
		add(line(210, 300, 195, 250));

		//house
		add(rect(80, 370, 100, 130));
		add(line(80, 370, 130, 320));
		add(line(180, 370, 130, 320));

		//tower_3
		add(rect(260, 350, 20, 150));
		add(line(260, 350, 270, 330));
		add(line(280, 350, 270, 330));

		//tower_4
		add(rect(310, 350, 20, 150));
		add(line(310, 350, 320, 330));
		add(line(330, 350, 320, 330));

		//tower_5
		add(rect(360, 350, 20, 150));
		add(line(360, 350, 370, 330));
		add(line(380, 350, 370, 330));

		//door
		add(rect(120, 450, 20, 50));
		add(line(120, 450, 130, 440));
		add(line(140, 450, 130, 440));

		//windows
		add(oval(90, 390, 20, 20));
		add(oval(150, 390, 20, 20));

	}


	//Line
	private GLine line(int x, int y, int z, int w)
	{
		GLine line = new GLine(x,y,z,w);
		return line;
	}

	// Rect
	private GRect rect(int x, int y, int z, int w)
	{
		GRect rect = new GRect(x, y, z, w);
		return rect;
	}

	//Oval
	private GOval oval(double x, double y, int z, int w)
	{
		GOval oval = new GOval(x, y, z, w);
		return oval;
	}



}