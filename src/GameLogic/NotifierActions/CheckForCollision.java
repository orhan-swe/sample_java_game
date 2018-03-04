package GameLogic.NotifierActions;

import java.util.Observable;

import GameLogic.GameObjects.CollisionDetector;
import GameLogic.GameObjects.GameObject;

public class CheckForCollision implements NotifierActionType{

	CollisionDetector cd; 
	public CheckForCollision(CollisionDetector cd) {
		this.cd = cd;
	}

	@Override
	public void run(GameObject go, Observable o, Object args) {
		go.checkIfColliding(this.cd, o, args);
	}


}
