package algefrogger.game.entity;

import java.awt.image.BufferedImage;

public class Turtle implements IEntity {

    int x;
    int y;
    int width;
    int height;
    boolean isPi;

    BufferedImage turtleIcon;

    public Turtle(int width, int height, boolean isPi,
            BufferedImage turtleIcon) {
        this.width = width;
        this.height = height;
        this.isPi = isPi;
        this.turtleIcon = turtleIcon;
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
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public boolean getChainLength() {
        return isPi;
    }

    @Override
    public BufferedImage getEntityImage() {
        return turtleIcon;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}
