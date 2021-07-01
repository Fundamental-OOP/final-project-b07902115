import control.Game;
import utils.CLI;
import utils.GUI;
import utils.UI;
import utils.GUIKeyListener;
import GUI.Window;
import java.util.concurrent.CountDownLatch;

public class Main{
	private static Window window;
	private static Game game;
	private static UI ui;
	
	public static void main(String[] args)
	{
		int mapHeight = 20;
		int mapWidth = 30;

		// ui = new CLI();
		ui = new GUI();
		
		window = new Window(mapHeight, mapWidth);
		ui.setWindow(window);
		
		game = new Game(ui, window, mapHeight, mapWidth);
		
		pressAnyKeyToStart();
	}
	
	public static void pressAnyKeyToStart() {
		
		CountDownLatch doneSignal = new CountDownLatch(1);
		GUIKeyListener kl = new GUIKeyListener(doneSignal);
		window.addKeyListener(kl);
		try {
			doneSignal.await();
		} catch (Exception e) {
			
		}
		
		window.StartGame();
		game.start();
	}
}