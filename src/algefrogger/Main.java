package algefrogger;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        int width = 520;
        int height = 480; //13x12, 40x40 blocks

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
