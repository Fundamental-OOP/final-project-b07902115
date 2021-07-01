package states;

import entities.Entity;
import utils.UI;
import utils.Toolkit;

public class State {
    public Entity affected;
    public int countdown;
    
    public State(Entity affected, int countdown) {
        this.affected = affected;
        this.countdown = countdown;
    }

    public State(Entity affected) {
        this.affected = affected;
        this.countdown = 3;
    }

    public State update() {
        this.countdown--;
        if (this.countdown >= 0)
            return this;
        return new Normal(this.affected);
    }

	/* Take action on behalf of Entity */
    public void takeTurn(UI ui, Entity target) {
		System.out.println("Ready");
        this.affected.readyPhase(ui);
		
		System.out.println("Move");
        this.affected.movePhase(ui, target);
		
		System.out.println("Action");
        this.affected.actionPhase(ui, target);
		
		System.out.println("Ending");
        this.affected.endingPhase(ui);
		
    }

	/* Modify damage (if needed) and deal the damage to the opponent */
    public void dealDamage(Entity target, int damage) {
        target.getState().takeDamage(damage);
    }

	/* Modify damage (if needed) and take the damage */
    public void takeDamage(int damage) {
        this.affected.takeDamage(damage);
    }
	
	@Override
	public String toString() {
		return String.format("%s (remain: %d)", this.getClass().getSimpleName(), this.countdown);
	}
}