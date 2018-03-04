package GameLogic.GameObjects;

import java.util.ArrayList;
import java.util.Observable;

import GameLogic.Algorithms.CollisionAlg;
import GameLogic.Algorithms.CollisionSide;
import GameLogic.Algorithms.CollisionType;
import GameLogic.Algorithms.PlayerBlock;
import GameLogic.ObjectMediator.ActionNotifierMediator;
import GameLogic.Observables.GameObjectActionNotifier;
import ImageLoader.Images;
import InputLogic.InputType;
import MainBootstraper.WorldCreator;
import UI_Logic.ObjectDrawers.ObjectDrawer;

public class Player extends GameObject implements InputReceiver, CollisionDetector {

	private static final String RenderNotifier = null;
	private int width = 48, height = 96;
	private float gravity = 0.2f;
	private int MAX_SPEED = 10;
	private int speed = 15;
	private int fallingSpeed = -10;

	private boolean falling = true;
	private boolean jumping = false;
	private ArrayList<CollidingBlock> collidingBlocks = new ArrayList<>();

	public Player(int x, int y, ObjectDrawer drawer, Images images) {
		super(x, y, drawer, images);
		dims.setWidth(width);
		dims.setHeight(height);
	}

	private void gravityMovement() {
		if (falling || jumping) {
			velY += gravity;
			if (velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
	}

	@Override
	public void render(Observable o, Object args) {
		collidingBlocks.clear();
		// if nothing has change velY and velX will be 0;
		dims.setY(dims.getY() + velY);
		dims.setX(dims.getX() + velX);
		gravityMovement();
		//this.mediator.checkForCollision(this);
		((GameObjectActionNotifier)(o)).checkForCollision(this);
		if (collidingBlocks.isEmpty()) {
			falling = true;
		}
		drawer.execute(images.getImages()[0], dims.getX(), dims.getY());

	}

	@Override
	public void onInput(InputType input) {

		switch (input) {
		case LEFT:
			if (!isBlocked(CollisionSide.LEFT))
				velX = -speed;
			break;
		case RIGHT:
			if (!isBlocked(CollisionSide.RIGHT))
				velX = speed;
			break;
		case UP:
			if (!jumping) {
				jumping = true;
				velY = fallingSpeed;
			}
			break;
		case STOP:
			velX = 0;
			break;
		default:
			break;
		}
		return;
	}

	private boolean isBlocked(CollisionSide side) {
		for (CollidingBlock collidingBlock : collidingBlocks) {
			if(collidingBlock.side == side)
				return true;
		}
		return false;
	}

	@Override
	public void checkIfColliding(CollisionDetector collisionDetector, Observable o, Object args) {
		collisionDetector.createCollisionAlgoritm(CollisionType.PLAYER, dims.getX(), dims.getY(), dims.getWidth(), dims.getHeight());
	}
	
	@Override
	public void createCollisionAlgoritm(CollisionType type, int x_block, int y_block, int width_block, int height_block) {
		CollisionAlg ca = null;
		if (type == CollisionType.BLOCK) {
			ca = new PlayerBlock(dims.getX(), dims.getY(), dims.getWidth(), dims.getHeight(), x_block, y_block, width_block, height_block);
		}
		if (ca != null && ca.checkCollisionSide() != CollisionSide.NA) {
			collidingBlocks.add(new CollidingBlock(type, ca.checkCollisionSide()));
			switch (ca.checkCollisionSide()) {
			case BOTTOM:
				velY = 0;
				falling = false;
				jumping = false;
				dims.setY(y_block - dims.getHeight());
				break;
			case TOP:
				dims.setY(y_block - height_block);
				velY = 0;
				break;
			case RIGHT:
				dims.setX(x_block - dims.getWidth());
				break;
			case LEFT:
				dims.setX(x_block - width_block);
				break;

			default:
				break;

			}
		}
	}
	private class CollidingBlock {
		public CollisionType type;
		public CollisionSide side;

		public CollidingBlock(CollisionType type, CollisionSide side) {
			this.type = type;
			this.side = side;
		}
	}


}
