package algefrogger.entity;

import java.awt.image.BufferedImage;

public class Turtle implements IEntity {

	int x;
	int y;
	int width;
	int height;
	boolean isPi;
	
	BufferedImage turtleIcon;
	
	public Turtle(int width, int height, boolean isPi, BufferedImage turtleIcon){
		this.width = width;
		this.height = height;
		this.isPi = isPi;
		this.turtleIcon = turtleIcon;
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

	public boolean getChainLength() {
		return isPi;
	}
	
	@Override
	public BufferedImage getEntityIcon() {
		return turtleIcon;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
