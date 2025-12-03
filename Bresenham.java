import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Bresenham extends JPanel {

    int x1, y1, x2, y2;
    String style; 

    Bresenham(int x1, int y1, int x2, int y2, String style) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.style = style.toLowerCase();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBresenham(g, x1, y1, x2, y2, style);
    }

    void drawBresenham(Graphics g, int x1, int y1, int x2, int y2, String style) {

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int err = dx - dy;

        int x = x1;
        int y = y1;

        int counter = 0; 

        while (true) {

            
            boolean drawPixel = false;

            switch (style) {
                case "solid":
                    drawPixel = true;
                    break;

                case "dashed":
                    drawPixel = (counter % 10 < 5); 
                    break;

                case "dotted":
                    drawPixel = (counter % 4 == 0); 
                    break;
            }

            if (drawPixel)
                g.fillRect(x, y, 2, 2); 

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

            counter++;
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Bresenham Line");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1: ");
        int x1 = sc.nextInt();

        System.out.print("Enter y1: ");
        int y1 = sc.nextInt();

        System.out.print("Enter x2: ");
        int x2 = sc.nextInt();

        System.out.print("Enter y2: ");
        int y2 = sc.nextInt();

        System.out.print("Enter line style (solid/dashed/dotted): ");
        String style = sc.next().toLowerCase();

       
        Bresenham panel = new Bresenham(x1, y1, x2, y2, style);

        f.add(panel);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}



