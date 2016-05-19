package algefrogger.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Car implements IEntity {

    int x;
    int y;
    int carvalue;
    BufferedImage carIcon;

    public Car(int xpos, int ypos, int value) {
        x = xpos;
        y = ypos;
        carIcon = new BufferedImage(40, 40, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = carIcon.createGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, carIcon.getWidth(), carIcon.getHeight());
        g.setColor(Color.BLACK);
        g.drawString("" + value, 0, 0);
    }

    public int getValue() {
        return carvalue;
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
        return carIcon.getWidth();
    }

    @Override
    public int getHeight() {
        return carIcon.getHeight();
    }

    @Override
    public BufferedImage getEntityImage() {
        return carIcon;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

}
