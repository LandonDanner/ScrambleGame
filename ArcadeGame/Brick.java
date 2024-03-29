import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions:
 *				Make the brick extend Block
 *
 *				Write the Brick constructor that takes an x, y, w, h to create a block.
 *
 *				Override the paint method to draw a Brick

				Choose to draw or import an image.
 *
 *				Go to BreakOut and do Step 3, then test in the runner.
 *
 *				If all works correctly then move on to Steps 4 - 6 in BreakOut.
 */

class Brick extends Block
{
    public Brick(int x, int y, int w, int h) {
        super(x,y,w,h);
    }
    public void paint( Graphics window )
    {

        // drawing methods for Java:
        // go to the Graphics Intro Folder
        window.setColor(Color.RED);

        window.fillRect(getX(), getY(), getW(), getH());
        window.drawRect(getX(), getY(), getW(), getH());


        //find and image for your paddle and put it here
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("Rocket2.png"); //use .gif or .png, you can choose the image
        g2.drawImage(img1, getX(), getY(), getW(), getH(), this);

    }


}