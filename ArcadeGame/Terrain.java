import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
class Terrain{
    private int height;
    public Terrain() {
        height=1;
    }

    public void setHeight(int x){
        height=x;
    }

    public int getHeight(){
        return height;
    }

    public void randomize() {
        int r=(int)Math.random()*4;
        if (r == 1 && getHeight()<8) {
            setHeight(getHeight()+1);
        }
        else if(getHeight()>1){
            setHeight(getHeight()-1);
        }
    }

    public int[][] coords(){
        int[][] stack= new int[getHeight()][2];

        for(int q=0; q<stack.length; q++){
            for(int r=0; r<stack[q].length; r++){
                stack[q][0]=2000;
                stack[q][1]=q*20;
            }
        }
        return stack;
    }
}
