package ImageLoader;

import java.awt.image.BufferedImage;

public class BlockImages extends Images {

	public BlockImages(String path) {
		ImageLoader loader = new ImageLoader();
		
		bufferedImages = new BufferedImage[2];

		try {
			sheet = loader.loadImage(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		spriteSheet = new SpriteSheet(sheet);
		bufferedImages[0] = spriteSheet.grabImage(1, 1, 32, 32); // dirt_block
		bufferedImages[1] = spriteSheet.grabImage(2, 1, 32, 32); // grass_block

	}

}