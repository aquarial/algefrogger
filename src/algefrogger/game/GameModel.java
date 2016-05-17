package algefrogger.game;

import java.util.ArrayList;
import java.util.List;

import algefrogger.game.entity.IEntity;

/**
 * Holds and runs a frogger game
 */
public class GameModel {
    private LevelState state;

    /**
     * Resets LevelState
     */
    public GameModel() {
        state = new LevelState();
    }

    /**
     * Gets a List of all the the IEntites in the LeveState
     * 
     * @return
     */
    public List<IEntity> getAllIEntities() {
        return state.getEntities();
    }

    /**
     * Moves player one unit to the left
     */
    public void movePlayerLeft() {
        // if (state.playerpos() < 40){
        // return;
        // }
        // state.moveplayerby(-40, 0);
    }

}
