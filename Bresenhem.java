import javax.swing.*;
import java.awt.*;

public class Bresenhem extends JPanel {

    int x1, x2, y1, y2;

    Bresenhem(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int err = dx - dy;

        int x=x1;
        int y=y1;

        while (true) {
            g.drawRect(x, y, 1, 1);
            if (x == x2 && y == y2)
                break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
    }

    public static void main(String str[]) {
        JFrame frame = new JFrame("Bresenhem Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bresenhem line = new Bresenhem(50, 50, 300, 200);
        frame.add(line);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
