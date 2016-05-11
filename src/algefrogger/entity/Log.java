package algefrogger.entity;

import java.awt.image.BufferedImage;

public class Log implements IEntity {

	int x;
	int y;
	int width;
	int height;
	int logLength;
	
	String logText;
	
	BufferedImage logIcon;
	
	public Log(int width, int height, int logLength, BufferedImage logIcon){
		this.width = width;
		this.height = height;
		this.logLength = logLength;
		this.logIcon = logIcon;
		
		logText = "ln(" + ((int)Math.pow(Math.E, logLength)) + ")";
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
	public BufferedImage getEntityIcon() {
		return logIcon;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
