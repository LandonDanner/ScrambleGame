import java.awt.*;
public class PlayerMovement extends Block
{
    private int speed; // a paddle has to have a speed to make it move

    public PlayerMovement( int ex, int wy, int wd, int ht, int sp)
    {
        super(ex,wy,wd,ht);
        speed=sp;
        //write the code for the Paddle constructor
        //must have a super constructor call
    }
    public void goLeft()
    {
        setX( getX() - speed*2 );
        if(getX()<=0) {
            setX(0);
        }
    }
    public void goRight() {
        setX(getX() + speed * 2);
        if (getX() >= 1880) {
            setX(1880);
        }
    }
    public void goUp()
    {   setY(getY() - speed*2);
        if(getY() <= 0) {
            setY(0);
        }
    }
    public void goDown()
    {	setY(getY() + speed*2);
        if(getY() >= 1000) {
            setY(1000);
        }
    }
    //	public void fire()
//	{
//		ball = new Ball(getX(), getY(), 20, 20);
//	}
//
    //overidde paint to draw your Paddle
    public void paint( Graphics window )
    {

        // drawing methods for Java:
        // go to the Graphics Intro Folder

        window.setColor(Color.BLACK);

        window.fillRect(getX(), getY(), getW(), getH());
        window.drawRect(getX(), getY(), getW(), getH());


        //find and image for your paddle and put it here
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("PlayerShip.png"); //use .gif or .png, you can choose the image
        g2.drawImage(img1, getX(), getY(), getW(), getH(), this);

    }

}
