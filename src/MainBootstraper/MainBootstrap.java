package MainBootstraper;

import java.util.Observable;

import GameLogic.ObjectFactory.OFactory;
import GameLogic.ObjectFactory.ObjectFactory;
import GameLogic.Observables.GameObjectActionNotifier;
import GameLogic.Observables.InputNotifier;
import ImageLoader.BlockImages;
import ImageLoader.Images;
import ImageLoader.PlayerImages;
import ImageLoader.WorldImages;
import InputLogic.KeyBoardEvent;
import UI_Logic.CanvasDrawer;
import UI_Logic.GraphicsObservable;
import UI_Logic.UIGraphicsObserver;
import UI_Logic.WindowFrame;
import UI_Logic.ObjectDrawers.BlockDrawer;
import UI_Logic.ObjectDrawers.ObjectDrawer;
import UI_Logic.ObjectDrawers.PlayerDrawer;
import UI_Logic.ViewMover.PlayerViewMover;
import UI_Logic.ViewMover.ViewMover;

public class MainBootstrap {

	// init ImageLoader
	private static Images playerImages = new PlayerImages("/player_sheet.png");
	private static Images blockImages = new BlockImages("/block_sheet.png");
	private static Images worldImages = new WorldImages("/level.png");

	// init UI
	private static GraphicsObservable go = new GraphicsObservable();
	private static UIGraphicsObserver playerDrawer = new PlayerDrawer();
	private static UIGraphicsObserver blockDrawer = new BlockDrawer();
	private static UIGraphicsObserver playerViewMover = new PlayerViewMover();
	private static CanvasDrawer cd = new CanvasDrawer(go);

	// init InputReader
	private static Observable inputNotifier = new InputNotifier();
	private static KeyBoardEvent kbe = new KeyBoardEvent(inputNotifier);

	// init GameLogic
	private static Observable renderNotifier = new GameObjectActionNotifier();
	private static OFactory af = new ObjectFactory(renderNotifier, inputNotifier);
	private static WorldCreator worldCreator = new WorldCreator(af);

		// init frame controller and start it
	private static FrameController fc = new FrameController(cd, renderNotifier);
	
	public static void main(String args[]) {
		
		go.addObserver(playerDrawer);
		go.addObserver(blockDrawer);
		go.addObserver(playerViewMover);
		new WindowFrame(800, 600, "Game Proto", cd);
		worldCreator.initLogic((ObjectDrawer)playerDrawer, (ObjectDrawer)blockDrawer, (ViewMover)playerViewMover, playerImages, blockImages, worldImages);
		cd.addKeyListener(kbe);

		fc.start();

	}

}
