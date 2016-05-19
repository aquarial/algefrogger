package algefrogger.game.entity;

import java.awt.image.BufferedImage;

public interface IEntity {

    /** @return X coordinate */
    int getX();

    /** @return Y coordinate */
    int getY();

    /** Moves entites to X */
    void setX(int new_x);

    /** Moves entites to X */
    void setY(int new_y);

    /** @return Width of image */
    int getWidth();

    /** @return Height of image */
    int getHeight();
    
    /** @return X movement speed of entity per tick */
    int getSpeed();

    /** @return Entity image */
    BufferedImage getEntityImage();
}
