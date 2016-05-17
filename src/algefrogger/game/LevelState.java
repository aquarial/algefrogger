package algefrogger.game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import algefrogger.IO.Resources;
import algefrogger.game.entity.Car;
import algefrogger.game.entity.IEntity;

/**
 * Holds position data of a level
 */
public class LevelState {

    private List<IEntity> entities;

    //@formatter:off
    /* 
     * LevelState uses (x,y) coordinates to place objects.
     * (0,0)     is the pixel in the upper-left corner.
     * (520,480) is the pixel in the lower-right corner.
     * 
     *  _ _ _ _ _ _ _ _ _ _ _ _ _ 
     * |3 | | | 8 | | | 4 | | | 2|
     * |= = = =   = = = =   = =  |
     * | e e   e e   e e   e e   | - 2 long e-turtle
     * |=   = = = = =   = = = =  | - 5 long log (ln148)
     * |  = = =   = = =   = = =  | - 3 long log (ln20)     
     * |p p   p p p   p p p   p p| - 3 long pi-turtles
     * |                         | - plain row
     * |------------7------3-----| - car lane
     * |---2---4--------6--------| - car lane
     * |---------5---------1-----| - car lane
     * |----3-----4-----8--------| - car lane
     * |_ _ _ _ _ _ X _ _ _ _ _ _| - starting row
     */
    //@formatter:on

    public LevelState() {
        entities = new ArrayList<>();

        // put cars and things in place
        // BufferedImage image = Resources.loadImageByName("x");
        //
        // IEntity car00 = new Car(20, 20, 7, image);
        // entities.add(car00);
        //
        // image = Resources.loadImageByName("Log5");
        // car00 = new Car(20, 20, 7, image);
        // entities.add(car00);
    }

    /**
     * Adds arg to internal list
     * 
     * @param arg
     */
    void addIEntity(IEntity arg) {
        entities.add(arg);
    }

    /**
     * All the entities that make up this level
     * 
     * @return
     */
    List<IEntity> getEntities() {
        return entities;
    }

}
