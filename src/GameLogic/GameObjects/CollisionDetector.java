package GameLogic.GameObjects;

import GameLogic.Algorithms.CollisionType;

public interface CollisionDetector {
	
	public void createCollisionAlgoritm(CollisionType type, int x, int y, int width, int height);
	
}
