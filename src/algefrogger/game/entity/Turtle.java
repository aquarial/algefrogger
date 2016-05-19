package algefrogger.game.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import algefrogger.IO.Resources;

public class Turtle implements IEntity {

    int x;
    int y;
    int width;
    int height;
    boolean isPi;

    BufferedImage turtleIcon;

    public Turtle(boolean isPi) {

        int numberOfTurtles = 0;
        BufferedImage turtle = new BufferedImage(0, 0,
                BufferedImage.TYPE_4BYTE_ABGR);
        if (isPi) {
            numberOfTurtles = 3;
            turtle = Resources.loadImageByName("pi");
        } else {
            numberOfTurtles = 2;
            turtle = Resources.loadImageByName("e");
        }

        width = 20 * numberOfTurtles;
        height = 20;

        turtleIcon = new BufferedImage(width, height,
                BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = turtleIcon.createGraphics();
        for (int i = 0; i < numberOfTurtles; i++) {
            g2.drawImage(turtle, i * 20, 0, null);
        }
        g2.dispose();

        this.isPi = isPi;
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
