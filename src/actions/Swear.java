package actions;

import java.awt.Point;
import java.util.List;
import entities.Entity;

public class Swear extends Action {
	/* WARNING: don't use this in the actual game, or the game might malfunction. */
    
    public Swear() {
        super("DO NOT SWEAR", 1.0, 0, 1);
    }
	
	@Override
    public void effect(Entity user, int attack, Entity enemy) {
		
    }
}