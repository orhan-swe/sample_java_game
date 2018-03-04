package GameLogic.ObjectFactory;

import GameLogic.GameObjects.GameObject;
import GameLogic.GameObjects.Block.BlockType;
import ImageLoader.Images;
import UI_Logic.ObjectDrawers.ObjectDrawer;

public interface OFactory {

	public GameObject createPlayer(int x, int y, ObjectDrawer playerDrawer, Images playerImages);
	public GameObject createBlock(int x, int y, ObjectDrawer blockDrawer, Images blockImages, BlockType blockType);

}
