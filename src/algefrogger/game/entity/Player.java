package algefrogger.game.entity;

import java.awt.image.BufferedImage;

import algefrogger.IO.Resources;

public class Player implements IEntity {

    int x;
    int y;
    int width;
    int height;

    BufferedImage playerIcon;

    public Player(int xpos, int ypos) {
        x = xpos;
        y = ypos;
        width = 40;
        height = 40;
        playerIcon = Resources.loadImageByName("x");
    }

    @Override
    public void setX(int new_x) {
        x = new_x;
    }

    @Override
    public void setY(int new_y) {
        y = new_y;
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
        return playerIcon;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}
