package GameLogic.Observables;

import java.util.Observable;

import GameLogic.NotifierActions.InputEvent;
import GameLogic.NotifierActions.InputReceived;
import InputLogic.InputType;

public class InputNotifier extends Observable {
	
	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(new InputReceived((InputType)arg));
	}

}
