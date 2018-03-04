package UI_Logic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Observable;

public class CanvasDrawer extends Canvas {

	private static final long serialVersionUID = 1L;

	private GraphicsObservable gNotifier;
	public static int WIDTH, HEIGHT;
	BufferStrategy bs;
	Graphics g;
	Graphics2D g2d;
	
	public CanvasDrawer(GraphicsObservable go)
	{
		WIDTH = getWidth();
		HEIGHT = getHeight();
		this.gNotifier = go;
	}
	public boolean setUpGraphics() {
		// TODO Auto-generated method stub
		bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return false;
		}
		g = bs.getDrawGraphics();
		g2d = (Graphics2D) g;

		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		gNotifier.updateGraphics(g);
		gNotifier.update2DGraphics(g2d);
		return true;
	}

	public void draw() {
		g.dispose();
		bs.show();
	}

}
