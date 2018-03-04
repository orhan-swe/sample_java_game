package UI_Logic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;

import UI_Logic.UpdateGraphicsCommand.New2DGraphicsCommand;
import UI_Logic.UpdateGraphicsCommand.NewGraphicsCommand;

public class GraphicsObservable extends Observable {
	
	public void notifyObservers(Object args) {
		this.setChanged();
		super.notifyObservers(args);
	}
	
	public void updateGraphics(Graphics g) {
		notifyObservers(new NewGraphicsCommand(g));
	}
	public void update2DGraphics(Graphics2D g2d) {
		notifyObservers(new New2DGraphicsCommand(g2d));
	}

}
