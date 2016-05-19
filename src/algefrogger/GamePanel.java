package algefrogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JPanel;

import algefrogger.game.GameModel;
import algefrogger.game.entity.IEntity;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private int width;
	private int height;
	private GameModel model;

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
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Erase background
		g2.setColor(Color.GREEN);
		g2.fillRect(0, 0, width, height);

		g2.setColor(Color.BLUE);
		g2.fillRect(0, 40, width, 40 * 5);

		g2.setColor(Color.BLACK);
		g2.fillRect(0, 7 * 40, width, 40 * 4);

		// Draw all the entities
		for (IEntity i : model.getAllIEntities()) {
			g2.drawImage(i.getEntityImage(), i.getX(), i.getY(), null);
		}

	}

	public void startgame() {
		model = new GameModel();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					GamePanel.this.sleep(60);
					GamePanel.this.repaint();
					model.update();
				}
			}
		}.start();
	}

	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	KeyAdapter createKeyListener() {
		return new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				handlePushedKey(e);
			}

			// @Override
			// public void keyReleased(KeyEvent e) {
			// handlePushedKey(e);
			// }

			int[] validCharKeyCodes = new int[] { 37, 38, 39, 40 };
			char[] characters = new char[] { 'l', 'u', 'r', 'd' };

			void handlePushedKey(KeyEvent e) {
				int keyCode = e.getExtendedKeyCode();
				int index = Arrays.binarySearch(validCharKeyCodes, keyCode);

				if (index >= 0) {
					model.addKeyInput(characters[index]);
				}
			}
		};
	}
}
