package GameLogic.NotifierActions;

import java.util.Observable;

import GameLogic.GameObjects.GameObject;

public interface NotifierActionType {
	
	public void run(GameObject go, Observable o, Object args);

}
