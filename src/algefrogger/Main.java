package algefrogger;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        int width = 400;
        int height = 600;

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel(width, height);
        panel.setPreferredSize(new Dimension(width, height));
        frame.getContentPane().add(panel);

        frame.setSize(frame.getPreferredSize());
        panel.startgame();
    }
}
