import javax.swing.*;
import java.awt.*;

public class DDA extends JPanel {

    int x1, y1, x2, y2;

    DDA(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        int xInc = dx / steps;
        int yInc = dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.drawRect(Math.round(x), Math.round(y), 1, 1);
            x += xInc;
            y += yInc;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DDA line = new DDA(50, 50, 300, 200);
        frame.add(line);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}