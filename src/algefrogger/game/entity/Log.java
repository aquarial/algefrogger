package algefrogger.game.entity;

import java.awt.image.BufferedImage;

import algefrogger.IO.Resources;

public class Log implements IEntity {

    int x;
    int y;
    BufferedImage logIcon;

    /**
     * Constructs a Log
     * 
     * @param xpos
     * @param ypos
     * @param logLength
     *            Must be 3, 4, or 5
     */
    public Log(int xpos, int ypos, int logLength) {
        x = xpos;
        y = ypos;
        logIcon = Resources.loadImageByName("Log" + logLength);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return logIcon.getWidth();
    }

    @Override
    public int getHeight() {
        return logIcon.getHeight();
    }

    @Override
    public BufferedImage getEntityImage() {
        return logIcon;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

}
