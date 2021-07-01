package actions;

import entities.Entity;

public class Skip extends Action {
    
    public Skip() {
        super("Skip", 0, 0, 0);
    }

    @Override
    public void effect(Entity user, int attack, Entity enemy) {
    }
}