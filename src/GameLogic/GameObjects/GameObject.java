package GameLogic.GameObjects;

import java.util.Observable;
import java.util.Observer;

import GameLogic.NotifierActions.NotifierActionType;
import GameLogic.ObjectMediator.ActionNotifierMediator;
import ImageLoader.Images;
import UI_Logic.ObjectDrawers.ObjectDrawer;

public abstract class GameObject implements Observer {

	protected int x, y;
	protected int velX = 0, velY = 0;
	protected ObjectDrawer drawer;
	protected Images images;
	protected Dimentions dims;
	protected ActionNotifierMediator mediator;

	public GameObject(int x, int y, ObjectDrawer drawer, Images images) {
		dims = new Dimentions(x, y);
		this.drawer = drawer;
		this.images = images;
		//this.mediator = om;
	}

	public void update(Observable o, Object args) {
		((NotifierActionType) args).run(this, o, args);
	}
	
	abstract public void render(Observable o, Object args); 
	
	abstract public void checkIfColliding(CollisionDetector cd, Observable o, Object args);

}
