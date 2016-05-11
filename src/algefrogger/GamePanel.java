package algefrogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private int width;
    private int height;

    GamePanel(int nwidth, int nheight) {
        super();
        width = nwidth;
        height = nheight;
        setBackground(Color.GREEN);
    }

    public void repaint(Graphics g) {

        // levelstate.getentities
        for (IEntity i : new IEntity[] {}) {
            BufferedImage image = i.getEntityIcon();
            g.drawImage(image, i.getX(), i.getY(), null);
        }
    }

    public void startgame() {

        while (true) {
            this.sleep(60);
            this.repaint();
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
