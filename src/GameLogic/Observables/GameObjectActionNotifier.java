package GameLogic.Observables;

import java.util.Observable;

import GameLogic.GameObjects.CollisionDetector;
import GameLogic.NotifierActions.CheckForCollision;
import GameLogic.NotifierActions.RenderObject;

public class GameObjectActionNotifier extends Observable {
	
	@Override
	public void notifyObservers(Object args) {
		setChanged();
		super.notifyObservers(new RenderObject());
		
	}

	public void checkForCollision(CollisionDetector go) {
		setChanged();
		super.notifyObservers(new CheckForCollision(go));
	}
}
