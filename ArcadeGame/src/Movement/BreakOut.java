import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;


/*
 *		Directions: Follow the directions in order. 
 *		(1) Paddle
 *			(1A) Make the paddle show up on the screen
 *			(1B) Make the paddle move
 *		(2) Ball
 *			(2A) Make the ball show up on the screen
 *			(2B) Make the ball bounce after you press the space bar
 *		(3) Make the bricks work
 *			(3A) Initialize the list of bricks
 *			(3B) add bricks to the list
 *			(3C) make the bricks show up on the screen
 *		(4) make the ball bounce off the paddle
 *		(5) make the ball bounce off the bricks
 *		(6) remove the bricks that get hit by the ball
 *		Test after each step.
 *
 *		Add methods, constructors, instance variables anywhere that is needed
 *		to enhance the game.
 *
 *		To get full credit you need to add two more features that are not included.
 */

class BreakOut extends JPanel implements Runnable, KeyListener
{
		private boolean[] keys; // this stores booleans for when a key is pressed or not.
			
		private Paddle pad;	// this is the paddle that moves across the bottom of the screen

		private Ball ball; // this is the ball that bounces around the screen

		private ArrayList< Brick > bricks; // this is the list of bricks that are to be drawn on the screen
		
		private int score = 0;

	
	public BreakOut() // create all instance in here
	{
		setBackground(Color.WHITE);

		//make the keys array big enough to store all keys pressed
		keys = new boolean[5];        // scroll down to see the keyPressed method

		pad = new Paddle(650, 100, 100, 60, 10); /* (1A) initialize the Paddle, put the paddle close to the bottom of the screen. */

		ball = new Ball(122,222,23,23, 87);
		/* (3A)initialize the ArrayList<Brick> */
		bricks = new ArrayList<Brick>();
//	    int j=1;
//	    int p=0;
//		for(int x=0;x<222;x+=1) {
//
//			bricks.add( new Brick(j , p , 40, 40 ) );
//			j+=40;
//			if(j>=1450) {
//				p+=40;
//				j=0;
//			}


		/* (3B) make a for loop to add Bricks to your ArrayList< Brick >
		 * 		bricks.add( new Brick( x, y , w, h ) );
		 * 		each brick will need to have different x & y coordinates, but same width and height
		 * 		the x & y coordinates should be based on the width and height you choose
		 */
	
			
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();	//
	}

	public void paint( Graphics window )// all other paint methods and game logic goes in here.
	{
		Color weird= new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		//window.setColor( Color.BLACK);
		window.setColor(Color.BLACK); window.fillRect( 0,0, 2000, 1200); // makes the background white
		window.drawRect( 0,0, 2000, 1200); // draws a black box around the outside

		window.setColor(Color.WHITE); // to change fonts, color, etc: go to the Graphics Intro Folder

		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + " , " + MouseInfo.getPointerInfo().getLocation().y + ")", 20, 1100 );
		window.drawString("Score: " + score, 20,1130);
		pad.paint( window );   //(1A) paints the paddle	
		/* (2A)  paint the ball */
		ball.paint(window);
		ball.move();
		ball.bounce();
		

		/* (3C) paint the bricks, must use a loop to paint each brick individually */
		
		for(int x=0;x<bricks.size();x++) {
			bricks.get(x).paint(window);
		}
		
		if(keys[0]) // W is pressed
		{
			pad.goUp();
		}
		if(keys[1]) // A is pressed
		{
			pad.goLeft();
		}
		if(keys[2]) // S is pressed
		{
			pad.goDown();
		}
		if(keys[3]) // D is pressed
		{
			pad.goRight();
		}
//		if(keys[4]) // space is pressed
//		{
//			pad.fire();
//		}
		
		/* (4) test if the ball is hitting the paddle, make the ball bounce off */
		if(ball.intersects(pad)) {
			ball.changeSpeed();
		}
		/* (5) test if the ball is hitting a brick, make the ball bounce off */

//	    for(int x=bricks.size()-1;x>=0;x--) {
//	    	if(ball.intersects(bricks.get(x))) {
//				bricks.remove(x);
//				ball.changeSpeed();
//				score++;
//			}
//		}
		if(score >= 222) {
			window.setColor(Color.RED);
			window.drawString("YOU WIN!!!", 690,550);
	    }
	    if(ball.getY()>1200) {
	    	ball.stop();
	    }
	    if(bricks.size()==1) {
	    }
	    if(bricks.size()==0) {
	    	ball.stop();
	    }
		/* (6) then remove the brick that got hit */
	}
	

// only edit if you would like to add more key functions	
	public void keyPressed(KeyEvent e)
	{   
		//Java KeyEvent docs
		//https://docs.oracle.com/javase/8/docs/api/java/awt/evtryewuiqtryeuwiqtreyiwuyueuyeiyuuyyuetiuyeriuerytent/KeyEvent.html
		
		if( e.getKeyCode()  == KeyEvent.VK_W )
		{
			keys[0]=true;
		}
		if( e.getKeyCode()  == KeyEvent.VK_A )
		{
			keys[1]=true;
		}
		if( e.getKeyCode()  == KeyEvent.VK_S )
		{
			keys[2]=true;
		}
		if( e.getKeyCode()  == KeyEvent.VK_D )
		{
			keys[3]=true;
		}
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			keys[4]=true;
		}
	}
/*****~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*****/
	public void keyTyped(KeyEvent e)
	{
		keyPressed( e );			
	}		
	public void keyReleased(KeyEvent e)
	{
		if( e.getKeyCode()  == KeyEvent.VK_W )
		{
			keys[0]=false;
		}
		if(e.getKeyCode()  == KeyEvent.VK_A) {
			keys[1]=false;
		}
		if( e.getKeyCode()  == KeyEvent.VK_S )
		{
			keys[2]=false;
		}
		if( e.getKeyCode()  == KeyEvent.VK_D )
		{
			keys[3]=false;
		}
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			keys[4]=false;
		}
	}	
	
	public void run()
	{
		try
		{
			while( true )
			{	
			   Thread.sleep( 15 );
			   repaint();
			}
		}
		catch( Exception e )
		{			
		}
	}
}