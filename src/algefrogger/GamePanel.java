package algefrogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.JPanel;

import algefrogger.game.GameModel;
import algefrogger.game.entity.IEntity;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private int width;
	private int height;
	private GameModel model;
	/** A screen buffer to reduce draws to JPanel */
	BufferedImage bufferImage;
	/** Graphics for the screen buffer */
	Graphics2D bufferGraphics;

	/**
	 * Sets up GamePanel
	 * 
	 * @param nwidth
	 * @param nheight
	 */
	GamePanel(int nwidth, int nheight) {
		super();
		addKeyListener(createKeyListener());
		width = nwidth;
		height = nheight;
		model = new GameModel();
		bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		bufferGraphics = bufferImage.createGraphics();

	}

	@Override
	public void paintComponent(Graphics g) {

		// Erase background
		bufferGraphics.setColor(Color.GREEN);
		bufferGraphics.fillRect(0, 0, width, height);

		// water
		bufferGraphics.setColor(Color.BLUE);
		bufferGraphics.fillRect(0, 40, width, 40 * 5);

		// road
		bufferGraphics.setColor(Color.BLACK);
		bufferGraphics.fillRect(0, 7 * 40, width, 40 * 4);

		// Lily Pads
		for (int i = 0; i < 4; i++) {
			bufferGraphics.setColor(Color.BLUE);
			bufferGraphics.fillRect(160 * i, 2, 40, 38);
			bufferGraphics.setColor(Color.GREEN);
			bufferGraphics.fillRect(160 * i + 10, 12, 20, 20);
			bufferGraphics.setColor(Color.BLACK);
			bufferGraphics.drawString(model.getAnswers().get(i) + "", 160*i + 15, 25);
		}

		// Draw all the entities
		for (IEntity i : model.getAllIEntities()) {
			bufferGraphics.drawImage(i.getEntityImage(), i.getX(), i.getY(), null);
		}
		// Draws player back on top
		IEntity p = model.getAllIEntities().get(0);
		bufferGraphics.drawImage(p.getEntityImage(), p.getX(), p.getY(), null);
		bufferGraphics.setColor(Color.BLACK);
		bufferGraphics.drawString(model.getEquationGen().getEquation(), 20, 460);
		g.drawImage(bufferImage, 0, 0, null);
		
	}

	/**
	 * Starts a background thread to update & render the game
	 */
	public void startgame() {
		model = new GameModel();
		new Thread() {
			@Override
			public void run() {
				while (true) {

					model.update();
					GamePanel.this.repaint();
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}.start();

	}

	/**
	 * Creates a KeyListener that notifies the model when arrow keys are pushed
	 * 
	 * @return Specified KeyAdapter
	 */
	KeyAdapter createKeyListener() {
		return new KeyAdapter() {

			/**
			 * Update keys known to be currently held down when a key is
			 * released
			 */
			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getExtendedKeyCode();
				int index = Arrays.binarySearch(validCharKeyCodes, keyCode);
				if (index >= 0) {
					keyIsNotPushed[index] = true;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				handlePushedKey(e);
			}

			int[] validCharKeyCodes = new int[] { 37, 38, 39, 40 };
			char[] characters = new char[] { 'l', 'u', 'r', 'd' };
			boolean[] keyIsNotPushed = new boolean[] { true, true, true, true };

			/**
			 * Only notifies the model if the key was not already held down
			 * 
			 * @param e
			 */
			void handlePushedKey(KeyEvent e) {
				int keyCode = e.getExtendedKeyCode();
				int index = Arrays.binarySearch(validCharKeyCodes, keyCode);

				if (index >= 0 && keyIsNotPushed[index]) {
					model.handleDirectionalInput(characters[index]);
					keyIsNotPushed[index] = false;
				}
			}

		};
	}
}
