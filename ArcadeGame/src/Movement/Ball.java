import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions: extend the Block class to use the Block methods
 *
 *				Override the paint method to draw a Ball
 *				
 *				Make an xspeed and a yspeed instance variable in order to make the ball bounce
 *				
 *				Create a Ball constructor, using the Paddle constructor as an example, it can still take
 *				in just one speed, then set both instance variables to that one speed.
 *				
 *				Create a bounce method that keeps the ball on the screen but bounces around the screen.
 *				Do NOT test if the ball is touching the bricks or the paddle in this method, you will do that
 *				in the game logic in BreakOut.java.
 *
 *				Go to BreakOut and do Step 2 and test it in the runner.
 *
 *				If all works then move on to Brick
 *				
 */

class Ball extends Block
{
	private int xspeed;
	private int yspeed;
	
	public Ball(int b,int x, int y, int h, int w) {
		super(x, y, h, w);
		xspeed=b;
		yspeed=b;
	}
	public void bounce() {
		
		if ( getX() > 1446 || getX()<1)
			xspeed=xspeed*-1;
		if(  getY()<1)
		    yspeed=yspeed*-1;
	}
	public void changeSpeed() {
		yspeed=yspeed*-1;
		if(yspeed <= 75){
			yspeed = yspeed + 1;
		}
	}
	public void move() {
		setX( getX() - xspeed);
		setY(getY() - yspeed);
	}
	public void stop() {
		yspeed = 0;
		xspeed = 0;
	}
	public void paint( Graphics window )
	{
		
		// drawing methods for Java: 
		// go to the Graphics Intro Folder
		
		window.setColor(Color.RED);

		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());
		

		//find and image for your paddle and put it here
    		Graphics2D g2 = (Graphics2D) window;
    		Image img1 = Toolkit.getDefaultToolkit().getImage("monkey.png");
    		//use .gif or .png, you can choose the image
    		g2.drawImage(img1, getX(), getY(), getW(), getH(), this);
    	
	}	

}