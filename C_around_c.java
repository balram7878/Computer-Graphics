import java.awt.*;
import javax.swing.*;

class Circle extends JPanel{
    private int big_r = 150;
    private int small_r = 75;
    private javax.swing.Timer timer;
    int angle = 0;

    public Circle()
    {
        timer = new javax.swing.Timer(50, e->{
            angle+=1;
            
            repaint();
        });
        timer.start();
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int center_x = getWidth()/2;
        int center_y = getHeight()/2;

        g.fillOval(center_x - big_r,center_y - big_r,big_r*2,big_r*2);

        int xpoint = (int)(center_x + big_r*Math.cos(Math.toRadians(angle + 180)));
        int ypoint = (int)(center_y + big_r*Math.sin(Math.toRadians(angle +180)));
        g.setColor(Color.RED);
       
        g.fillOval(xpoint-small_r,ypoint-small_r, small_r*2, small_r*2);

 int xpoint1 = (int)(center_x + big_r*Math.cos(Math.toRadians(angle)));
        int ypoint1 = (int)(center_y + big_r*Math.sin(Math.toRadians(angle)));

          g.setColor(Color.YELLOW);
        g.fillOval(xpoint1-small_r,ypoint1-small_r, small_r*2, small_r*2);

        int xpoint2 = (int)(center_x + big_r*Math.cos(Math.toRadians(angle +90)));
        int ypoint2 = (int)(center_y + big_r*Math.sin(Math.toRadians(angle +90)));

          g.setColor(Color.GREEN);
        g.fillOval(xpoint2-small_r,ypoint2-small_r, small_r*2, small_r*2);


        int xpoint3 = (int)(center_x + big_r*Math.cos(Math.toRadians(angle +270)));
        int ypoint3 = (int)(center_y + big_r*Math.sin(Math.toRadians(angle+270)));

          g.setColor(Color.GRAY);
        g.fillOval(xpoint3-small_r,ypoint3-small_r, small_r*2, small_r*2);
        
          

    }

}

public class C_around_c {
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Shrinking Circle");
        Circle c = new Circle();
        frame.add(c);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);

    }
    
}

