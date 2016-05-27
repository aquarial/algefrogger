package algefrogger.game;

import java.util.List;
import java.util.Random;

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
	/** If the player will be reset this tick */
	boolean playerWillBeResetToStart = true;
	/** Generates equation and answers*/
	EquationGenerator equationGen;
	/** Answers on the lily pads*/
	List<Integer> answers;
	/** Current player score */
	private int score;
	/** If game is finished, is true*/
	boolean isGameFinished = false;

	/**
	 * Resets LevelState
	 */
	public GameModel() {
		state = new LevelState();
		
		equationGen = new EquationGenerator();
		answers = equationGen.getFakeAnswers(3);
		answers.add(new Random().nextInt(4), equationGen.getAnswer());
		score = 102;
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
	 * 
	 * @return EquationGenerator object used
	 */
	public EquationGenerator getEquationGen() {
		return equationGen;
	}
	
	/**
	 * Gets a list of the answers for the lily pads
	 * @return
	 */
	public List<Integer> getAnswers(){
		return answers;
	}
	
	/**
	 * Generates new numbers for the lily padsS
	 */
	public void generateNewLilyNumbers() {
		equationGen.generateNewEquation();
		answers = equationGen.getFakeAnswers(3);
		answers.add(new Random().nextInt(4), equationGen.getAnswer());
	}
	
	/**
	 * Gets if the game is considered finished
	 * @return
	 */
	public boolean isGameFinished() {
		return isGameFinished;
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

	/**
	 * Returns the speed of the entity below the player, if it exists.
	 * 
	 * @return speed or 0
	 */
	public int checkBelowSpeed() {
		Player p = state.getPlayer();
		for (IEntity IE : state.getEntities()) {
			if (IE == p)
				continue;
			if (IE.getX() < p.getX() + 20 && p.getX() + 20 < IE.getX() + IE.getWidth() && p.getY() == IE.getY())
				return IE.getSpeed();
		}

		// if nothing below && player is in water, reset position
		if (40 <= p.getY() && p.getY() <= 5 * 40) {
			playerWillBeResetToStart = true;
		}
		return 0;
	}
	/**
	 * Will check if entity provided is touching a car (used with player)
	 * @param e1 entity to check
	 * @return true = touching, false = not touching
	 */
	public boolean isTouchingCar(IEntity e1){
		for (IEntity IE : state.getCars()){
			if ((e1.getY() == IE.getY()) && (e1.getX() <= IE.getX() + IE.getWidth()) && (e1.getX() + e1.getWidth() >= IE.getX()))
				// score -= IE.getPointValue();
				return true;
		}
		
		return false;
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
		}
		player.setSpeed(checkBelowSpeed());

		// keeps player inbounds
		if (state.playerXPos() < 0){
			player.setX(0);
			checkBelowSpeed();
		}
		else if (state.playerXPos() > 480){
			player.setX(480);
			checkBelowSpeed();
		}
		else if (state.playerYPos() > 440){
			player.setY(440);
		}
		else if (state.playerYPos() < 0)
			player.setY(0);
		
		// Player jumping into answer spots
		else if (state.playerYPos() < 40) {
			if (0 < state.playerXPos() + 20 && state.playerXPos() + 20 < 45){
				player.setX(0);
				if (!(getAnswers().get(0) == equationGen.getAnswer()))
						playerWillBeResetToStart = true;
				else
					isGameFinished = true;
			}
			else if (160 < state.playerXPos() + 20 && state.playerXPos() + 20 < 210){
				player.setX(160);
				if (!(getAnswers().get(1) == equationGen.getAnswer()))
					playerWillBeResetToStart = true;
				else
					isGameFinished = true;
			}
			else if (320 < state.playerXPos() + 20 && state.playerXPos() + 20 < 350){
				player.setX(320);
				if (!(getAnswers().get(2) == equationGen.getAnswer()))
					playerWillBeResetToStart = true;
				else
					isGameFinished = true;
			}
			else if (480 < state.playerXPos() + 20 && state.playerXPos() + 20 < 525){
				player.setX(480);
				if (!(getAnswers().get(3) == equationGen.getAnswer()))
					playerWillBeResetToStart = true;
				else
					isGameFinished = true;
			}
			else{
				player.setY(40);
				player.setSpeed(checkBelowSpeed());
			}	
				
		}
		
		// movement & reseting if out of bounds
		for (IEntity IE : state.getEntities()) {
			IE.setX(IE.getX() + IE.getSpeed());
			if (IE.getSpeed() > 0 && IE.getX() - IE.getWidth() >= 520)
				IE.setX(-IE.getWidth());
			else if (IE.getSpeed() < 0 && IE.getX() + IE.getWidth() <= 0)
				IE.setX(520 + IE.getWidth());
		}
		
		if (playerWillBeResetToStart || isTouchingCar(player)) {

			if (playerWillBeResetToStart) {
				score -= 2;
			}

			player.setX(240);
			player.setY(480);
			generateNewLilyNumbers();
			playerWillBeResetToStart = false;
		}
	}
	
	
	public int getCurrentScore() {
		return score;
	}
}
