package algefrogger.game.entity;

import java.awt.image.BufferedImage;

public class Car implements IEntity {

    int x;
    int y;
    int width;
    int height;
    int value;

    BufferedImage carIcon;

    public Car(int width, int height, int value, BufferedImage carIcon) {
        this.width = width;
        this.height = height;
        this.value = value;
        this.carIcon = carIcon;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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

    @Override
    public BufferedImage getEntityImage() {
        return carIcon;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}
