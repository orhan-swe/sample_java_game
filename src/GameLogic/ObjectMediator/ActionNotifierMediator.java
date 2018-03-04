package GameLogic.ObjectMediator;

import GameLogic.GameObjects.CollisionDetector;
import GameLogic.Observables.GameObjectActionNotifier;

public class ActionNotifierMediator extends ObjectMediator {

	private GameObjectActionNotifier actionNotifier;
	public ActionNotifierMediator(GameObjectActionNotifier actionNotifier) {
		this.actionNotifier = actionNotifier;
	}
	public void checkForCollision(CollisionDetector go) {
		actionNotifier.checkForCollision(go);
	}
}
