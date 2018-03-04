package GameLogic.ObjectFactory;

import java.util.Observable;

import GameLogic.GameObjects.Block;
import GameLogic.GameObjects.Block.BlockType;
import GameLogic.GameObjects.GameObject;
import GameLogic.GameObjects.Player;
import ImageLoader.Images;
import UI_Logic.ObjectDrawers.ObjectDrawer;

public class ObjectFactory implements OFactory{

	private Observable renderNotifier, inputNotifier;
	public ObjectFactory(Observable renderNotifier, Observable inputNotifier) {
		this.renderNotifier = renderNotifier;
		this.inputNotifier = inputNotifier;
	}

	@Override
	public GameObject createPlayer(int x, int y, ObjectDrawer playerDrawer, Images playerImages) {
		GameObject player = new Player(x, y, playerDrawer, playerImages);
		this.renderNotifier.addObserver(player);
		this.inputNotifier.addObserver(player);
		return player;
	}

	@Override
	public GameObject createBlock(int x, int y, ObjectDrawer blockDrawer, Images blockImages, BlockType type) {
		GameObject block = new Block(x, y, blockDrawer, blockImages, type);
		this.renderNotifier.addObserver(block);
		return block;
	}

}
