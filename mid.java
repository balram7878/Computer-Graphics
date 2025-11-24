import java.awt.*;
import javax.swing.*;

class object extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g);
    }

    void drawCircle(Graphics g) {
        int r = 100;
        int xc = 250, yc = 250;   // Center of circle

        int x = 0;
        int y = r;
        int p = 1 - r;

        while (x <= y) {
            g.setColor(Color.pink);

            // plotting 8 symmetric points
            putPixel(g, xc + x, yc + y);
            putPixel(g, xc - x, yc + y);
            putPixel(g, xc + x, yc - y);
            putPixel(g, xc - x, yc - y);
            putPixel(g, xc + y, yc + x);
            putPixel(g, xc - y, yc + x);
            putPixel(g, xc + y, yc - x);
            putPixel(g, xc - y, yc - x);

            x++;

            if (p < 0) {
                p = p + 2 * x + 1;
            } else {
                y--;
                p = p + 2 * (x - y) + 1;
            }
        }
    }

    void putPixel(Graphics g, int x, int y) {
        g.fillRect(x, y, 2, 2);
    }
}

public class mid {
    public static void main(String arg[]) {
        JFrame frame = new JFrame("Midpoint Circle");
        object ob = new object();
        frame.add(ob);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
