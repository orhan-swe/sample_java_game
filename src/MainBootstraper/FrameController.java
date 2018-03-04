package MainBootstraper;

import java.awt.RenderingHints;
import java.util.Observable;

import UI_Logic.CanvasDrawer;

public class FrameController implements Runnable {
	
	private CanvasDrawer canvas;
	private Observable renderNotifier;
	private int FPS = 69;
	public FrameController(CanvasDrawer canvas, Observable renderNotifier) {
		this.canvas = canvas;
		this.renderNotifier = renderNotifier;
	}
	public synchronized void start() {
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
		int renderCalled = 0;
		long forTest = System.currentTimeMillis();
		while (true) {
			long oldTime = System.currentTimeMillis();
			runOneFrame();
			long currentTime = System.currentTimeMillis();
			long diff = currentTime - oldTime;

			// this will not be true 60 FPS but close to it..
			try {
				// diff = 0;
				long oneSecMinusDiff = 1000 - diff;
				if (oneSecMinusDiff > 0)
					Thread.sleep(oneSecMinusDiff / FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			renderCalled++;
			if (renderCalled == FPS) {
				// this should be FPS calls in around 1000 ms..
				System.out.println("Framse in " + ((System.currentTimeMillis() - forTest)));
				forTest = System.currentTimeMillis();
				renderCalled = 0;
			}
		}
	}
	
	public void runOneFrame() {
			if(!canvas.setUpGraphics())
				return;
			renderNotifier.notifyObservers();
			canvas.draw();
	}

}
