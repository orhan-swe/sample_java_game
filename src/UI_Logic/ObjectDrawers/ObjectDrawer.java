package UI_Logic.ObjectDrawers;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import UI_Logic.UIGraphicsObserver;

abstract public class ObjectDrawer extends UIGraphicsObserver {

	public void execute(Image image, int x, int y) {
		super.g.drawImage(image, (int) x, (int) y, null);
		return;
	}

}
