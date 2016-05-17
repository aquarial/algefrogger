package algefrogger.game.entity;

import java.awt.image.BufferedImage;

public class Player implements IEntity {

    int x;
    int y;
    int width;
    int height;

    BufferedImage playerIcon;

    public Player(int width, int height, BufferedImage playerIcon) {
        this.width = width;
        this.height = height;
        this.playerIcon = playerIcon;
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
