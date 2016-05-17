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

    /**
     * Sets up GamePanel
     * 
     * @param nwidth
     * @param nheight
     */
    GamePanel(int nwidth, int nheight) {
        super();
        width = nwidth;
        height = nheight;
        setBackground(Color.GREEN);
        model = new GameModel();
    }

    @Override
    public void paintComponent(Graphics g) {

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
