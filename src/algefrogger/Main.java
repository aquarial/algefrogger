package algefrogger;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        int width = 400;
        int height = 600;

        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        GamePanel panel = new GamePanel(width, height);
        frame.getContentPane().add(panel);

        panel.startgame();
    }
}
