package UI_Logic.UpdateGraphicsCommand;

import java.awt.Graphics;

import UI_Logic.UIGraphicsObserver;

public class NewGraphicsCommand implements UpdateGraphicsCommand {

	private Graphics g;
	public NewGraphicsCommand(Graphics g) {
		this.g = g;
	}
	public void run(UIGraphicsObserver gObserver) {
		gObserver.updateGraphics(g);
	}
}
