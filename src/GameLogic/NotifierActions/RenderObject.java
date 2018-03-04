package GameLogic.NotifierActions;

import java.util.Observable;

import GameLogic.GameObjects.GameObject;

public class RenderObject implements NotifierActionType{

	@Override
	public void run(GameObject go, Observable o, Object args) {
		go.render(o, args);
	}


}
