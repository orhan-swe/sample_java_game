package InputLogic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;

import GameLogic.NotifierActions.InputEvent;

public class KeyBoardEvent extends KeyAdapter implements InputEvent {

	private Observable inputObservable;

	public KeyBoardEvent(Observable keyObservable) {
		this.inputObservable = keyObservable;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		notify(getKey(e.getKeyCode()));
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A)
			notify(InputType.STOP);
	}

	private InputType getKey(int key) {
		InputType inputType = null;
		switch (key) {
		case (KeyEvent.VK_D):
			inputType = InputType.RIGHT;
			break;
		case (KeyEvent.VK_ESCAPE):
			System.exit(1);
			break;
		case (KeyEvent.VK_A):
			inputType = InputType.LEFT;
			break;
		case (KeyEvent.VK_W):
			inputType = InputType.UP;
			break;
		case (KeyEvent.VK_SPACE):
			inputType = InputType.UP;
			break;
		default:
			inputType = InputType.NA;
			break;
		}
		return inputType;
	}

	public void notify(InputType inputType) {
		inputObservable.notifyObservers(inputType);
	}
}
