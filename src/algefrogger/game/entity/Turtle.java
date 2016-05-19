package algefrogger.game.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import algefrogger.IO.Resources;

public class Turtle implements IEntity {

	int x;
	int y;
	int width;
	int height;
	final static int SPEED = -5;
	boolean isPi;

	BufferedImage turtleIcon;

	public Turtle(int xpos, int ypos, boolean isPi) {

		int numberOfTurtles = 0;
		BufferedImage turtle;

		if (isPi) {
			numberOfTurtles = 3;
			turtle = Resources.loadImageByName("pi");
		} else {
			numberOfTurtles = 2;
			turtle = Resources.loadImageByName("e");
		}

		width = 40 * numberOfTurtles;
		height = 40;

		x = xpos;
		y = ypos;

		turtleIcon = new BufferedImage(width, height,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2 = turtleIcon.createGraphics();
		for (int i = 0; i < numberOfTurtles; i++) {
			g2.drawImage(turtle, i * 40, 0, null);
		}
		g2.dispose();

		this.isPi = isPi;
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

	public boolean getChainLength() {
		return isPi;
	}

	@Override
	public BufferedImage getEntityImage() {
		return turtleIcon;
	}

	@Override
	public int getSpeed() {
		return SPEED;
	}

}
