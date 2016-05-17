package algefrogger.game;

import java.util.ArrayList;
import java.util.List;

import algefrogger.game.entity.IEntity;

//Game logic
public class GameModel {
    private LevelState state;

    public GameModel() {
        state = new LevelState();
    }

    public List<IEntity> getAllIEntities() {
        return new ArrayList<>();
    }

    void movePlayerLeft() {
        // if (state.playerpos() < 40){
        // return;
        // }
        // state.moveplayerby(-40, 0);
    }

}
