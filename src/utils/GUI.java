package utils;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import actions.*;
import entities.Hero;
import entities.Monster;
import GUI.Window;

public class GUI implements UI, WindowInteractions {
    private Window window;
	private GUIKeyListener kl;
	private CountDownLatch doneSignal;
	
    public GUI() {
		kl = new GUIKeyListener(doneSignal);
		kl.setEnabled(false);
    }
	
	@Override
	public void setWindow(Window window) {
        this.window = window;
		this.window.addKeyListener(kl);
	}

    @Override
    public Direction getMove() {
		Direction result = Direction.NONE;
		doneSignal = new CountDownLatch(1);
		kl.resetMove(doneSignal);
		
		kl.setEnabled(true);
		while(result == Direction.NONE) {
			doneSignal = new CountDownLatch(1);
			kl.resetMove(doneSignal);
			
			try {
				// System.out.println("Waiting.");
				showInfo("Press arrow keys or [W, A, S, D] to move. " +
				"[H] or [Space bar] to hold position.");
				doneSignal.await();
				
				result = kl.getMove();
			} catch (Exception e) {
				showInfo(e.toString());
				Toolkit.sleep(500);
			}
		}
		kl.setEnabled(false);
		
		System.out.println(result);
		if(result != Direction.NONE)
			return result;
		else
			throw new java.lang.RuntimeException("Direction not specified in GUI");
    }

    @Override
    public Action getAction(List<Action> availableAction) {
        Action result = new Swear();
		doneSignal = new CountDownLatch(1);
		kl.resetMove(doneSignal);
		int numActions = availableAction.size();
		
		StringBuilder actionList = new StringBuilder();
		actionList.append("Avaliable actions: ");
		for (int i = 0; i < availableAction.size(); i++) {
			Action action = availableAction.get(i);
			String actionAsString = String.format("(%d) %s ", i, action.getName());
			actionList.append(actionAsString);
		}
		
		kl.setEnabled(true);
		while(result.getName().equals("DO NOT SWEAR")) {
			doneSignal = new CountDownLatch(1);
			kl.resetMove(doneSignal);
			try {
				System.out.println("Waiting.");
				showInfo(actionList.toString());
				doneSignal.await();
				
				result = availableAction.get(kl.getActionIndex(numActions));
			} catch (Exception e) {
				showInfo(e.toString());
				Toolkit.sleep(500);
			}
		}
		kl.setEnabled(false);

        return result;
    }

    @Override
    public void gameOver(boolean won) {
        System.out.println("Game over!");
		String msg;
        if (won) {
			msg = "Congratulations, you win!";
		}
        else {
			msg = "You lose...";
		}
        showInfo(msg);
		window.EndGame(msg);
    }

	/* Interactions with Window */
    
	@Override
    public void showInfo(String information) {
        window.setStringToShow(information);
    }
	
	/* Set string to show on HUD */
    @Override
	public void setStringToShow(String information) {
		window.setStringToShow(information);
	}
	
	/* Update HeroFigure */
    @Override
	public void setHeroStats(Hero hero) {
		window.setHeroPos(hero.getLocation());
		window.setHeroCurrentAction(hero.getFigureAction());
		window.setHUDHeroHPP(hero.getHPP());
		window.setHUDHeroSTA(hero.getSTA());
		window.setHeroSize(hero.getSize());
		window.setCurrentState(hero.getState().toString());
	}
	
	/* Update BossFigure */
    @Override
	public void setMonsterStats(Monster monster) {
		window.setBossPos(monster.getLocation());
		window.setBossCurrentAction(monster.getFigureAction());
		window.setHUDBossHPP(monster.getHPP());
		window.setBossSize(monster.getSize());
	}
}