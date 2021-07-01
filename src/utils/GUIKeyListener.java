package utils;

import java.awt.event.*;
import java.util.concurrent.CountDownLatch;
import GUI.Window;

public class GUIKeyListener extends KeyAdapter {
    private Window window;
	private int keyCode;
	private boolean enabled = true;
	private CountDownLatch doneSignal;

    public GUIKeyListener(CountDownLatch doneSignal){
		resetMove(doneSignal);
    }
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Direction getMove() {
		Direction result = Direction.NONE;
		
		switch(keyCode){
			case KeyEvent.VK_UP:    // UP
				result = Direction.UP;
				break;
			case KeyEvent.VK_LEFT:  // Left
				result = Direction.LEFT;
				break;
			case KeyEvent.VK_DOWN:  // DOWN
				result = Direction.DOWN;
				break;
			case KeyEvent.VK_RIGHT: // Right
				result = Direction.RIGHT;
				break;
			case KeyEvent.VK_W:     // UP
				result = Direction.UP;
				break;
			case KeyEvent.VK_A:     // Left
				result = Direction.LEFT;
				break;
			case KeyEvent.VK_S:     // DOWN
				result = Direction.DOWN;
				break;
			case KeyEvent.VK_D:     // Right
				result = Direction.RIGHT;
				break;
			case KeyEvent.VK_H:     // Skip turn
				result = Direction.HOLD;
				break;
			case KeyEvent.VK_SPACE: // Skip turn
				result = Direction.HOLD;
				break;
			default:
				throw new java.lang.RuntimeException("Invalid input!");
		}
		
		return result;
	}
	
	public int getActionIndex(int numActions) {
		int result = keyCode - KeyEvent.VK_0;
		if(result < 0 || result >= numActions)
			throw new java.lang.RuntimeException("Invalid choice of action");
		return result;
	}
	
	public void resetMove(CountDownLatch doneSignal) {
		keyCode = 0;
		this.doneSignal = doneSignal;
	}

    public void keyTyped(KeyEvent e) {
		
    }

    public void keyPressed(KeyEvent e) {
		if(!enabled)
			return;
		keyCode = e.getKeyCode();
		doneSignal.countDown();
        // System.out.println("keyPressed" + e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
    }
}