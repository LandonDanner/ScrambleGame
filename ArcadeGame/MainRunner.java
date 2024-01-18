import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.SystemColor.window;

/*public class MainRunner extends JFrame{

    private int duration;
    private static final int WIDTH = 2600;
    private static final int HEIGHT = 1800;

    public MainRunner(){
        super("Scramble");

        setSize(WIDTH,HEIGHT);

        MovingBackground thing= new MovingBackground(0);
        getContentPane().add(thing);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main( String args[] ) {
        MainRunner run = new MainRunner();
    }
}
*/
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions: Go to all the other labs and press F9 (build) on each of them in order.
 *				then come back to this runner and press F10 (run);
 *				Then follow the directions in the other labs starting with Lab01.
 */

class BreakOutRunner extends JFrame
{
    private static final int WIDTH = 2000;
    private static final int HEIGHT = 1200;
    public BreakOutRunner()
    {
        super("BreakOut");

        setSize(WIDTH,HEIGHT);

        //This line loads the BreakOut game
        getContentPane().add( new BreakOut() );

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        BreakOutRunner run = new BreakOutRunner();
    }
}