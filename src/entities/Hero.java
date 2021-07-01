package entities;

import actions.*;
import states.*;
import utils.UI;
import utils.CLI;
import utils.Direction;
import utils.WindowInteractions;
import utils.Toolkit;
import java.awt.Point;
import java.awt.Dimension;

public class Hero extends Entity {
    private UI input;
    
    public Hero(UI input) {
        super("Hero", 100, 100, 5, 10);
        this.input = input;
		super.setSize(3, 3);
    }

    public Hero(String name, int hp, int mp, int sta, int attack, 
    UI input) {
        super(name, hp, mp, sta, attack);
        this.input = input;
		super.setSize(1, 1);
    }

	/* Entity Actions */
	
	@Override
    public void readyPhase(UI ui) {
		
        this.state = this.state.update();
        this.sta.reset();
		this.setFigureAction("idle");
		
		ui.showInfo(this.getStatus());
		((WindowInteractions) ui).setHeroStats(this);
		Toolkit.sleep(5000);
    }
	
	@Override
    public void movePhase(UI ui, Entity target) {
		
        while (super.sta.getVal() > 0) {
			Point currentPos = this.getLocation();
            Direction move = ((UI)this.input).getMove();
			if (move == Direction.HOLD) {
				break;
			}
			System.out.println(move);
			
			Point newPoint = newLocation(currentPos, move.translate());
			
			try {
				this.setLocation(newPoint, target);
				this.setFigureAction("run");
				super.sta.modVal(-1);
			}
			catch (java.lang.RuntimeException e) {
				ui.showInfo("New position invalid.");
			}
			
			String moveMsg = String.format(
				"%s moved to (%d, %d)",
				super.name,
				this.getLocation().x,
				this.getLocation().y
			);
			ui.showInfo(moveMsg);
			((WindowInteractions) ui).setHeroStats(this);
        }
		
		Toolkit.sleep(2000);
		this.setFigureAction("idle");
		((WindowInteractions) ui).setHeroStats(this);
    }

	@Override
	public void actionPhase(UI ui, Entity target) {
		StringBuilder actionList = new StringBuilder();
		actionList.append("Avaliable actions: ");
		for (int i = 0; i < availableActions.size(); i++) {
			Action action = availableActions.get(i);
			String actionAsString = String.format("(%d) %s ", i, action.getName());
			actionList.append(actionAsString);
		}
		ui.showInfo(actionList.toString());

        Action actionChosen;
        actionChosen = this.input.getAction(super.availableActions);
		super.mp.modVal(actionChosen.getCost());
		this.setFigureAction("attack");
		ui.showInfo(super.name + " used " + actionChosen.getName());
		((WindowInteractions) ui).setHeroStats(this);
        actionChosen.effect(this, super.attack, target);
		
		Toolkit.sleep(2000);
		this.setFigureAction("idle");
		((WindowInteractions) ui).setHeroStats(this);
    }
	
	/* Private Functions */
	
	private Point newLocation(Point currentPos, Dimension dim) {
		int x = currentPos.x;
		int y = currentPos.y;
		int deltaX = dim.height;
		int deltaY = dim.width;
		return new Point(x + deltaX, y + deltaY);
	}
}