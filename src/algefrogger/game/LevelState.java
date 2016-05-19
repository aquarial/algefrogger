package algefrogger.game;

import java.util.ArrayList;
import java.util.List;

import algefrogger.game.entity.IEntity;
import algefrogger.game.entity.Player;

/**
 * Holds position data of a level
 */
public class LevelState {

    private List<IEntity> entities;
    private Player player;
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
        
        player = new Player(240, 480);
        
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
    
    /**
     * Gets player X position
     * @return X position
     */
    public int playerXPos(){
    	return player.getX();
    }
    
    /**
     * Gets player Y position
     * @return Y position
     */
    public int playerYPos() {
    	return player.getY();
    }
    
    public void movePlayerBy(int x, int y){
//    	player.setX(player.getX() + x);
//    	player.setY(player.getY() + y);
    }

}
