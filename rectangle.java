import javax.swing.*;
import java.awt.*;

class Rect extends JPanel{

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int[] xPoints = {100,150,50};
        int[] yPoints = {50,150,150};
        g.drawPolygon(xPoints,yPoints,3);

    }

    
}

class Rect_Container{
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Line drawing");
        Rect r1 = new Rect();
        frame.add(r1);


        frame.setSize(500,500);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);

    }
}

