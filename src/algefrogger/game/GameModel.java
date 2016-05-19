package algefrogger.game;

import java.awt.Graphics;
import java.util.List;

import algefrogger.game.entity.IEntity;

/**
 * Holds and runs a frogger game
 */
public class GameModel {
	private LevelState state;
	/**
	 * u = up, d = down, l = left, r = right
	 */
	char lastPushedButton = 'u';
	boolean recentPush = false;

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
		if (state.playerXPos() < 40) {
			return;
		}
		state.movePlayerBy(-40, 0);
	}

	/**
	 * Moves player one unit to the right
	 */
	public void movePlayerRight() {
		if (state.playerXPos() >= 480) {
			return;
		}
		state.movePlayerBy(40, 0);
	}

	/**
	 * moves player 1 unit up
	 */
	public void movePlayerUp() {
		if (state.playerYPos() < 40) {
			return;
		}
		state.movePlayerBy(0, -40);
	}

	/**
	 * Moves player one unit down
	 */
	public void movePlayerDown() {
		if (state.playerYPos() >= 440) {
			return;
		}
		state.movePlayerBy(0, 40);
	}

	/**
	 * This method shouldn't be like this, but I don't care what you think
	 */
	public void update() {
		
	}
}
