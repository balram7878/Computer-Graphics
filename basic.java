import javax.swing.*;

class Basic {
    public static void main(String arg[])
    {
        JFrame frame = new JFrame("Button");
        frame.setSize(500,500);
            JButton bt = new JButton("click me");
            bt.setBounds(100,10,40,40);
            frame.add(bt);
        frame.setVisible(true);   
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}