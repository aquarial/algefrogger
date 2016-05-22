package algefrogger.game;

import java.util.ArrayList;
import java.util.List;

import algefrogger.game.entity.Car;
import algefrogger.game.entity.IEntity;
import algefrogger.game.entity.Log;
import algefrogger.game.entity.Player;
import algefrogger.game.entity.Turtle;

/**
 * Holds position data of a level<br>
 * LevelState uses (x,y) coordinates to place objects.
 * <p>
 * (0,0) is the pixel in the upper-left corner.<br>
 * (520,480) is the pixel in the lower-right corner.<br>
 * <p>
 * 
 * <pre>
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
 * </pre>
 */
public class LevelState {

    private List<IEntity> entities;
    private List<Log> logs;
    private List<Turtle> turtles;
    private List<Car> cars;
    private Player player;

    /**
     * Constructs default state
     * <p>
     * Entities are already placed inside the level
     */
    public LevelState() {
        entities = new ArrayList<>();
        logs = new ArrayList<>();
        turtles = new ArrayList<>();
        cars = new ArrayList<>();
        
        player = new Player(240, 480);
        
        addIEntity(player);
        
        // e-turtles
        for (int i = 0; i < 4; i++)
        	addIEntity(new Turtle(120*i + 40, 80, false));
        // pi-turtles
        for (int i = 0; i < 3; i++)
        	addIEntity(new Turtle(160*i - 40, 200, true));
        // 3-logs
        for (int i = 0; i < 3; i++)
        	addIEntity(new Log(160 * i + 40, 160, 3));
        // 4-logs
        for (int i = 0; i < 2; i++)
        	addIEntity(new Log(200 * i, 40, 4));
        // 5-logs
        for (int i = 0; i < 3; i++)
        	addIEntity(new Log(240*i + 80, 120, 5));
    }

    /**
     * Adds arg to internal list
     * 
     * @param arg
     */
    private void addIEntity(IEntity arg) {
        entities.add(arg);

        if (arg instanceof Log)
        	logs.add((Log)arg);
        
        else if(arg instanceof Turtle)
        	turtles.add((Turtle)arg);
        
        else if(arg instanceof Car)
        	cars.add((Car)arg);
    }

    /**
     * All the entities that make up this level
     * @return
     */
    List<IEntity> getEntities() {
        return entities;
    }
    
    /**
     * All the logs that make up this level
     * @return
     */
    List<Log> getLogs() {
        return logs;
    }
    
    /**
     * All the turtles that make up this level
     * @return
     */
    List<Turtle> getTurtles() {
        return turtles;
    }
    
    /**
     * All the cars that make up this level
     * @return
     */
    List<Car> getCars() {
        return cars;
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
    
    /**
     * Get player being used
     * @return Player object
     */
    public Player getPlayer() {
    	return player;
    }
    
    /**
     * Moves player entity by args
     * @param x pixels
     * @param y pixels
     */
    public void movePlayerBy(int x, int y){
    	player.setX(player.getX() + x);
    	player.setY(player.getY() + y);
    }

}
