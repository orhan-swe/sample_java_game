package UI_Logic.ViewMover;

import java.awt.Graphics2D;
import java.util.Observable;

import UI_Logic.CanvasDrawer;
import UI_Logic.UIGraphicsObserver;

public class PlayerViewMover extends ViewMover{

	private int x, y;

	public void move(int xPosition, int yPosition) throws Exception{
		x = CanvasDrawer.WIDTH/2 - xPosition;
		super.g2d.translate(x, y);
	}

}
