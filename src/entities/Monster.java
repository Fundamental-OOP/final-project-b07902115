package entities;

import java.util.Random;

import states.*;
import actions.*;
import utils.UI;
import utils.WindowInteractions;
import utils.Toolkit;

public class Monster extends Entity {
    private Random rand = new Random();

    public Monster() {
        super("Monster", 1000, 1000, 2, 10);
		super.setSize(12, 20);
    }

    public Monster(String name, int hp, int mp, int sta, int attack) {
        super(name, hp, mp, sta, attack);
		super.setSize(12, 20);
    }
	
	/* Entity Actions */
	
	@Override
    public void readyPhase(UI ui) {
		
        this.state = this.state.update();
        this.sta.reset();
		this.setFigureAction("idle");
		
		ui.showInfo(this.getStatus());
		((WindowInteractions) ui).setMonsterStats(this);
		Toolkit.sleep(5000);
    }
	
	@Override
    public void movePhase(UI ui, Entity target) {
		this.setFigureAction("run");
		((WindowInteractions) ui).setMonsterStats(this);
        // TODO
		
		String moveMsg = String.format(
			"%s moved to (%d, %d)",
			super.name,
			this.getLocation().x,
			this.getLocation().y
		);
		ui.showInfo(moveMsg);
		
		Toolkit.sleep(2000);
		this.setFigureAction("idle");
		((WindowInteractions) ui).setMonsterStats(this);
    }

	@Override
    public void actionPhase(UI ui, Entity target) {
        // TODO
        int index = rand.nextInt(super.availableActions.size());
        Action actionChosen = super.availableActions.get(index);
        super.mp.modVal(actionChosen.getCost());
		this.setFigureAction("attack");
		((WindowInteractions) ui).setMonsterStats(this);
        ui.showInfo(super.name + " used " + actionChosen.getName());
        actionChosen.effect(this, super.attack, target);
		
		Toolkit.sleep(2000);
		this.setFigureAction("idle");
		((WindowInteractions) ui).setMonsterStats(this);
    }
}