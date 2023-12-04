import java.awt.*;
import javax.swing.*;

import static java.awt.SystemColor.window;

public class MainRunner extends JFrame{

    private int duration;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public MainRunner(){
        super("MainRunner");

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
