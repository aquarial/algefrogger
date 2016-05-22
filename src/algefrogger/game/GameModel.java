package algefrogger.game;

import java.util.List;

import algefrogger.game.entity.IEntity;
import algefrogger.game.entity.Player;

/**
 * Holds and runs a frogger game
 */
public class GameModel {
	/** Internal level data */
	private LevelState state;
	/** u = up, d = down, l = left, r = right */
	char lastPushedButton = 'u';
	/** If input should be handled this tick */
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
		state.movePlayerBy(-40, 0);
	}

	/**
	 * Moves player one unit to the right
	 */
	public void movePlayerRight() {
		state.movePlayerBy(40, 0);
	}

	/**
	 * moves player 1 unit up
	 */
	public void movePlayerUp() {
		state.movePlayerBy(0, -40);
	}

	/**
	 * Moves player one unit down
	 */
	public void movePlayerDown() {
		state.movePlayerBy(0, 40);
	}

	/**
	 * Lets the model know the player has pushed a direction
	 * <p>
	 * The input will be handled next tick.
	 * 
	 * @param direction
	 *            A character in {'u', 'l', 'r', 'd'}
	 */
	public void handleDirectionalInput(char direction) {
		lastPushedButton = direction;
		recentPush = true;
	}

	public int checkBelowSpeed() {
		Player p = state.getPlayer();
		for (IEntity IE : state.getEntities()) {
			if (IE == p)
				continue;
			if (IE.getX() < p.getX() + 20 && p.getX() + 20 < IE.getX() + IE.getWidth() && p.getY() == IE.getY())
				return IE.getSpeed();
		}
		return 0;
	}

	/**
	 * This method shouldn't be like this, but I don't care what you think
	 */
	public void update() {
		Player player = state.getPlayer();

		if (recentPush) {
			switch (lastPushedButton) {
			case 'u':
				movePlayerUp();
				break;
			case 'd':
				movePlayerDown();
				break;
			case 'l':
				movePlayerLeft();
				break;
			case 'r':
				movePlayerRight();
				break;
			}
			recentPush = false;
			player.setSpeed(checkBelowSpeed());
		}

		// keeps player inbounds
		if (state.playerXPos() < 0)
			player.setX(0);
		else if (state.playerXPos() > 480)
			player.setX(480);
		else if (state.playerYPos() > 440)
			player.setY(440);

		// Player jumping into answer spots
		else if (state.playerYPos() < 40) {
			if (0 < state.playerXPos() + 20 && state.playerXPos() + 20 < 45)
				player.setX(0);
			else if (160 < state.playerXPos() + 20 && state.playerXPos() + 20 < 210)
				player.setX(160);
			else if (320 < state.playerXPos() + 20 && state.playerXPos() + 20 < 350)
				player.setX(320);
			else if (480 < state.playerXPos() + 20 && state.playerXPos() + 20 < 525)
				player.setX(480);
			else
				player.setY(40);
		}

		// movement & reseting if out of bounds
		for (IEntity IE : state.getEntities()) {
			IE.setX(IE.getX() + IE.getSpeed());
			if (IE.getSpeed() > 0 && IE.getX() - IE.getWidth() >= 520)
				IE.setX(-IE.getWidth());
			else if (IE.getSpeed() < 0 && IE.getX() + IE.getWidth() <= 0)
				IE.setX(520 + IE.getWidth());
		}
	}
}
