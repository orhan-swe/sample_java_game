package ImageLoader;

import java.awt.image.BufferedImage;

public abstract class Images {

	protected SpriteSheet spriteSheet;
	protected BufferedImage sheet;

	protected BufferedImage[] bufferedImages;

	public BufferedImage[] getImages() {
		return bufferedImages;
	}
}
