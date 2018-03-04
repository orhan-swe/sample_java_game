package UI_Logic.UpdateGraphicsCommand;

import java.awt.Graphics2D;

import UI_Logic.UIGraphicsObserver;

public class New2DGraphicsCommand implements UpdateGraphicsCommand{

	private Graphics2D g2d;
	public New2DGraphicsCommand(Graphics2D g2d) {
		this.g2d = g2d;
	}
	public void run(UIGraphicsObserver gObserver) {
		gObserver.update2DGraphics(g2d);
	}
}
