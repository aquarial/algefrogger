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

	BufferedImage screen;
	Graphics2D g2;

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
		screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g2 = screen.createGraphics();

	}

	@Override
	public void paintComponent(Graphics g) {

		// Erase background
		g2.setColor(Color.GREEN);
		g2.fillRect(0, 0, width, height);

		// water
		g2.setColor(Color.BLUE);
		g2.fillRect(0, 40, width, 40 * 5);

		// road
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 7 * 40, width, 40 * 4);

		// Lily Pads
		for (int i = 0; i < 4; i++) {
			g2.setColor(Color.BLUE);
			g2.fillRect(160 * i, 2, 40, 38);
			g2.setColor(Color.GREEN);
			g2.fillRect(160 * i + 10, 12, 20, 20);
		}

		// Draw all the entities
		for (IEntity i : model.getAllIEntities()) {
			g2.drawImage(i.getEntityImage(), i.getX(), i.getY(), null);
		}
		// Draws player back on top
		IEntity p = model.getAllIEntities().get(0);
		g2.drawImage(p.getEntityImage(), p.getX(), p.getY(), null);

		g.drawImage(screen, 0, 0, null);
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

			void handlePushedKey(KeyEvent e) {
				int keyCode = e.getExtendedKeyCode();
				int index = Arrays.binarySearch(validCharKeyCodes, keyCode);

				if (index >= 0 && keyIsNotPushed[index]) {
					model.addKeyInput(characters[index]);
					keyIsNotPushed[index] = false;
				}
			}

		};
	}
}
