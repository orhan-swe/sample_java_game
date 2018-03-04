package ImageLoader;

import java.awt.image.BufferedImage;

public class PlayerImages extends Images {

	public PlayerImages(String path) {
		ImageLoader loader = new ImageLoader();

		bufferedImages = new BufferedImage[1];
		try {
			sheet = loader.loadImage(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		spriteSheet = new SpriteSheet(sheet);
		
		bufferedImages[0] = spriteSheet.grabImage(1, 1,  32, 64);

	}

}