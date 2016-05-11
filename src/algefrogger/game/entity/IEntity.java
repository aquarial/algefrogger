package algefrogger.game.entity;

import java.awt.image.BufferedImage;

public interface IEntity {
	
	void setX(int x);
	void setY(int y);
	int getX();
	int getY();
	int getWidth();
	int getHeight();
	
	BufferedImage getEntityIcon();
	
	void update();
}
