import acm.program.*;
import acm.graphics.*;

public class BouncingBall extends GraphicsProgram
{
    public void run()
    {

        int x = (getWidth()-30)/2;
        int y = (getHeight()-30)/2;
      
        GOval ball = new GOval(x, y, 30, 30);
        ball.setFilled(true);
        add(ball);
        int dx = 1;
        int dy = 1;

        while(true)
        {
            x= x+dx;
            y= y+dy;
            ball.move(dx, dy);
            pause(p);

            if ((x>= (getWidth()-30)  )  || (x<= 0))
            {
                dx= -dx;
            }
            if ((y>= (getHeight()-30)  )  || (y<= 0))
            {
                dy= -dy;
            }


        }
    }
    private static final int p = 1;

}    