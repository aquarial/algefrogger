package algefrogger.IO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Resources {

	/**
	 * Gets the picture of the start for the name supplied
	 * 
	 * @param name
	 * @return Buffered image of a similar name
	 */
	public static BufferedImage loadImageByName(String name) {
		InputStream inputstream = Resources.class.getResourceAsStream("pics/" + name + ".png");
		try {

			BufferedImage image = ImageIO.read(inputstream);
			return scaleImage(image, 40);

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not find image " + name + ".png");
			System.err.println("Check if you added it.");
		}
		// Will not happen naturally. I will supply the levelpics data.
		return null;
	}

	/**
	 * Scales input image so its width is new_width
	 *
	 * @param imageToScale
	 * @param new_height
	 * @return Scaled image
	 */
	public static BufferedImage scaleImage(BufferedImage imageToScale, int new_height) {
		float ratio = imageToScale.getWidth() / (float) imageToScale.getHeight();
		int new_width = (int) (ratio * new_height);

		BufferedImage newImage = new BufferedImage(new_width, new_height, imageToScale.getType());
		newImage.createGraphics().drawImage(imageToScale, 0, 0, new_width, new_height, null);
		return newImage;
	}
}
