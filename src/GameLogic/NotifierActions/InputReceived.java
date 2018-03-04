package GameLogic.NotifierActions;

import java.util.Observable;

import GameLogic.GameObjects.GameObject;
import GameLogic.GameObjects.InputReceiver;
import InputLogic.InputType;

public class InputReceived implements NotifierActionType{

	InputType e;
	public InputReceived(InputType e) {
		this.e = e;
	}
	@Override
	public void run(GameObject ir, Observable o, Object args) {
		((InputReceiver)ir).onInput(this.e);
	}

}
