package actions;

import java.awt.Point;
import java.util.List;
import utils.Toolkit;
import entities.Entity;

public abstract class Action {
    protected String name;
    protected double multiplier;
    protected int cost;
    protected int effectiveDistance;
    
    public Action(String name, double multiplier, int cost, int effectiveDistance) {
        this.name = name;
        this.multiplier = multiplier;
        this.cost = cost;
        this.effectiveDistance = effectiveDistance;
    }

    public String getName() { return this.name; }
    public int getCost() { return this.cost; }

    protected boolean inReach(Entity user, Entity enemy) {
		
		int distance = Toolkit.calDistance(
			user.getHitLoc(),
			user.getHitSize(),
			enemy.getHitLoc(),
			enemy.getHitSize()
		);
		
        return distance <= this.effectiveDistance;
    }

    protected void damaging(Entity target, int attack) {
        target.getState().takeDamage((int)(this.multiplier * attack));
    }
	
    public abstract void effect(Entity user, int attack, Entity enemy);
}