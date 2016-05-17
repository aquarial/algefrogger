package algefrogger;

import java.awt.Color;
import java.awt.Graphics;

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
        model = new GameModel();
        setBackground(Color.GREEN);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, width, height);
        for (IEntity i : model.getAllIEntities()) {
            g.drawImage(i.getEntityIcon(), i.getX(), i.getY(), null);
        }
    }

    public void startgame() {
        model = new GameModel();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    GamePanel.this.sleep(60);
                    GamePanel.this.repaint();
                }
            }
        }.start();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
