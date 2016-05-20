package algefrogger.game.entity;

import java.awt.image.BufferedImage;

import algefrogger.IO.Resources;

public class Player implements IEntity {

    int x;
    int y;
    int width;
    int height;
    int speed = 0;

    BufferedImage playerIcon;

    public Player(int xpos, int ypos) {
        x = xpos;
        y = ypos;
        width = 40;
        height = 40;
        //Change once tested
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
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
    
}
