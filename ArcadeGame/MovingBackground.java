import java.awt.*;
import javax.swing.*;
public class MovingBackground extends JPanel implements Runnable{
    private int time;
    public MovingBackground(int t){
        time=t;
        new Thread(this).start(); /*You have to start a new Thread in a Runnable */
    }
    public void paintComponent( Graphics window )
    {

        //this allows us to put a png,jpg, or gif
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("StarSky.jpg"); /*the image cannot be in the SRC folder*/
        g2.drawImage(img1, 0-(time*4) , 0 , 3800 , 2000 , this);


    }

    public void run()
    {

        try
        {
            while( true )
            {
                Thread.sleep(50);
                if(time==-100){
                    time=0;
                }
                time++;
                if(time==100){
                    time=-100;
                }
                repaint();
            }
        }
        catch( Exception e )
        {

        }
    }
}
