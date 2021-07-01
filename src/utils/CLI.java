package utils;

import java.util.List;
import java.awt.Point;
import actions.*;
import entities.Hero;
import entities.Monster;
import GUI.Window;

public class CLI implements UI, WindowInteractions {
    private Inputs input = new Inputs();
	private Window window;
	
	@Override
	public void setWindow(Window window) {
		this.window = window;
	}
	
	/* Reads the move direction from CLI */
    @Override
    public Direction getMove() {
        boolean validInput = false;
        Direction result = Direction.NONE;

        while (!validInput) {
            showInfo("Type direction[up, down, left, right] you wanna move.");
            String line = input.in.nextLine().trim();
            System.out.println("Accepted input: \"" + line + "\"");
            switch (line) {
                case "up":
                    result = Direction.UP;
                    validInput = true;
                    break;
                case "down":
                    result = Direction.DOWN;
                    validInput = true;
                    break;
                case "left":
                    result = Direction.LEFT;
                    validInput = true;
                    break;
                case "right":
                    result = Direction.RIGHT;
                    validInput = true;
                    break;
                case "u":
                    result = Direction.UP;
                    validInput = true;
                    break;
                case "d":
                    result = Direction.DOWN;
                    validInput = true;
                    break;
                case "l":
                    result = Direction.LEFT;
                    validInput = true;
                    break;
                case "r":
                    result = Direction.RIGHT;
                    validInput = true;
                    break;
                default:
                    System.out.println("Illegal input!");
                    // throw new UnsupportedOperationException();
            }
        }

		return result;
    }

	/* Reads the next Action from CLI */
    @Override
    public Action getAction(List<Action> avaliableAction) {
        boolean validInput = false;
        Action result = new BasicAttack();

        while (!validInput) {
            System.out.println("Type an Integer to choose an action below.");
            for (Action action : avaliableAction) {
                System.out.println("(" + avaliableAction.indexOf(action) + ") " 
                + action.getName());
            }

            try {
                int choice = Integer.parseInt(input.in.nextLine());
                result = avaliableAction.get(choice);
				validInput = true;
            }
            catch (Exception e) {
                System.out.println("Illegal input!");
                // throw new UnsupportedOperationException();
            }
        }

        return result;
    }

	/* Decides whether the game should be ended */
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

    @Override
    public void showInfo(String information) {
        System.out.println(information);
		setStringToShow(information);
    }
	
	/* Interactions with Window */
	
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