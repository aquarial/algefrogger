package algefrogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import algefrogger.game.GameModel;
import algefrogger.game.entity.IEntity;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private int width;
    private int height;
    private GameModel model;

    GamePanel(int nwidth, int nheight) {
        super();
        width = nwidth;
        height = nheight;
        setBackground(Color.GREEN);
        model = new GameModel();
    }

    public void repaint(Graphics g) {

        // levelstate.getentities
        for (IEntity i : model.getAllIEntities()) {
            BufferedImage image = i.getEntityIcon();
            g.drawImage(image, i.getX(), i.getY(), null);
        }
    }

    public void startgame() {
        model = new GameModel();
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
