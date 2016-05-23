package algefrogger.game.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Car implements IEntity {

    int x;
    int y;
    int carvalue;
    int speed;
    BufferedImage carIcon;

    public Car(int xpos, int ypos, int value) {
        x = xpos;
        y = ypos;
        if ((y/40)%2 == 1)
        	speed = -1 * value;
        else
        	speed = value;
        
        String tmp = "" + value;
                
        carIcon = new BufferedImage(40, 40, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = carIcon.createGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, carIcon.getWidth(), carIcon.getHeight());
        g.setColor(Color.WHITE);
        g.drawString("" + value, 15, 25);
    }

    public int getValue() {
        return carvalue;
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
	public int getSpeed() {
		return speed;
	}

}
