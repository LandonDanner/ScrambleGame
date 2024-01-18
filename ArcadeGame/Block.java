import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions:
 *
 *		Write the intersects method below.
 *
 *		Then move on to Block
 */

abstract class Block extends Canvas
{
    private int x, y, w, h; //these are instance variables

    //this is the constructor for a Block
    public Block( int ex, int wy, int wd, int ht)
    {
        x=ex;
        y=wy;
        w=wd;
        h=ht;
    }

    // All Blocks will have all of these set and get methods
    public int getX( ){ return x; }
    public void setX( int ex ){ x = ex; }
    public int getY( ){ return y; }
    public void setY( int wy ){ y = wy; }
    public int getW(){ return w; }
    public int getH(){ return h; }


    public boolean intersects( Block other )
    {
        Rectangle bounds = new Rectangle(other.getX(), other.getY(), other.getW(), other.getH());
        Rectangle ron = new Rectangle(x,y,w,h);
        if(ron.intersects(bounds)) {
            return true;
        }
        return false;




        /* Easy Way:
         * 		Copy and Paste the following URL in google chrome
         *		https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
         *		make new Rectangle, using this Block's x,y,w,h
         *		make new Rectangle, using the other Block's x,y,w,h
         *		return if the two rectangles intersect, use the Rectangle's intersects method.
         */

        /* Hard Way:
         *		Write your own intersects logic!! Return if the two blocks are intersecting.
         */


    }
}