package GameLogic.Algorithms;

import java.awt.Rectangle;

public class PlayerBlock implements CollisionAlg {

	private Rectangle block;
	//sub is used for sub rectangle size, if speed is high this may need to increase..
	private int sub = 20;
	int x, y, width, height, x2, y2, width2, height2;
	public PlayerBlock(int x, int y, int width, int height, int x2, int y2, int width2, int height2) {
		this.x = x;
		this.y = y; 
		this.width = width;
		this.height = height;
		this.x2 = x2;
		this.y2 = y2;
		this.width2 = width2;
		this.height2 = height2;
		block = new Rectangle(x2, y2, width2, height2);
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle (x + sub, y+height-sub, width-sub*2, sub); 
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(x+sub, y, width-sub*2, sub);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y+sub, sub, height-sub*2);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle(x+width-sub, y+sub, sub, height-sub*2);
	}

	@Override
	public CollisionSide checkCollisionSide() {
		if (intersectsObject(getBoundsBottom())) 
			return CollisionSide.BOTTOM;
		else if (intersectsObject(getBoundsTop()))
			return CollisionSide.TOP;
		else if ( intersectsObject(getBoundsLeft()))
			return CollisionSide.LEFT;
		else if ( intersectsObject(getBoundsRight()))
			return CollisionSide.RIGHT;
		// TODO Auto-generated method stub
		return CollisionSide.NA;
	}
	
	public boolean intersectsObject(Rectangle r) {
		return this.block.getBounds().intersects(r);
	}
	
}
