package algefrogger;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		int width = 520;
		int height = 480; // 13x12, 40x40 blocks

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel panel = new GamePanel(width, height);
		panel.setPreferredSize(new Dimension(width, height));
		frame.getContentPane().add(panel);

		frame.setSize(frame.getPreferredSize());
		panel.startgame();

		/*
		 * HEY PARTNER
		 * THIS IS REALLY HARD TO MISS
		 * BECAUSE IT'S ALSO IN THE README
		 * I DIGRESS
		 * IF YOU WANT, YOU CAN:
		 * CLEAN UP SOME GAMEMODEL/LEVELSTATE CODE
		 * ADD THE CARS
		 * WORK DISPLAYING THE EQUATION AND THE ANSWERS AT TOP (I'll be working on this, but you can finish parts I haven't if I haven't pushed recently)
		 * HAVE FUN
		 */
		panel.requestFocusInWindow();
	}
}
