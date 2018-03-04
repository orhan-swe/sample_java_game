package GameLogic.GameObjects;

import java.awt.Rectangle;
import java.util.Observable;

import GameLogic.Algorithms.CollisionType;
import ImageLoader.Images;
import UI_Logic.ObjectDrawers.ObjectDrawer;

public class Block extends GameObject {
	
	private BlockType dirtBlock;

	public Block(int x, int y,  ObjectDrawer blockDrawer, Images blockImages, BlockType dirtBlock) {
		super(x, y, blockDrawer, blockImages);
		dims.setHeight(32);
		dims.setWidth(32);
		this.dirtBlock = dirtBlock;
	}

	public enum BlockType {
		DIRT_BLOCK, GRASS_BLOCK;	
	}
     
	public void render(Observable o, Object args) {
		drawer.execute(images.getImages()[0], dims.getX(), dims.getY());
	}
	public Rectangle getBounds() {
		return new Rectangle(dims.getX(), dims.getY(), dims.getWidth(), dims.getHeight());
	}
	
	@Override
	public void checkIfColliding(CollisionDetector collisionDetector, Observable o, Object args) {
		collisionDetector.createCollisionAlgoritm(CollisionType.BLOCK, dims.getX(), dims.getY(), dims.getHeight(), dims.getHeight());
	}

	public boolean intersectsObject(Rectangle r) {
		return this.getBounds().intersects(r);
	}
}
