package UI_Logic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import UI_Logic.UpdateGraphicsCommand.UpdateGraphicsCommand;

public class UIGraphicsObserver implements Observer {

	protected Graphics g;
	protected Graphics2D g2d;
	
	@Override
	public void update(Observable o, Object arg) {
		((UpdateGraphicsCommand) arg).run(this);
	}

	public void updateGraphics(Graphics g) {
		this.g = g;
	}
	public void update2DGraphics(Graphics2D g2d) {
		this.g2d = g2d;
	}
}
