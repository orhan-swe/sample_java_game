package MainBootstraper;

import java.awt.image.BufferedImage;

import GameLogic.GameObjects.Block;
import GameLogic.GameObjects.GameObject;
import GameLogic.ObjectFactory.OFactory;
import ImageLoader.Images;
import UI_Logic.ObjectDrawers.ObjectDrawer;
import UI_Logic.ViewMover.ViewMover;

public class WorldCreator {

	private OFactory af;
	public WorldCreator(OFactory af) {
		this.af = af;
	}

	public void initLogic(ObjectDrawer playerDrawer, ObjectDrawer blockDrawer,
			ViewMover PlayerViewMover, Images playerImages, Images blockImages, Images worldImages) {
		
		BufferedImage image = worldImages.getImages()[0];
		int w = image.getWidth();
		int h = image.getHeight();

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int pixel = image.getRGB(x, y);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				// check to see if we are on the white pixel:
				if (red == 255 && green == 255 && blue == 255) {
					GameObject block = af.createBlock(x * 32, y * 32, blockDrawer, blockImages, Block.BlockType.DIRT_BLOCK);
				}
				// check to see if we have a blue pixel to create player
				if (red == 0 && green == 0 && blue == 255) {
					GameObject player = af.createPlayer(x * 32, y * 32, playerDrawer, playerImages);
				}

			}
		}
	}

}
