package algefrogger.game.entity;

import java.awt.image.BufferedImage;

public interface IEntity {

    void setX(int x);

    void setY(int y);

    /** @return X coordinate */
    int getX();

    /** @return Y coordinate */
    int getY();

    /** @return Width of image */
    int getWidth();

    /** @return Height of image */
    int getHeight();

    /** @return Entity image */
    BufferedImage getEntityImage();

    void update();
}
