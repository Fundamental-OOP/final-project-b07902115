package actions;

import entities.Entity;

public class BasicAttack extends Action {
    
    public BasicAttack() {
        super("Basic Attack", 1.0, 0, 1);
    }

	@Override
    public void effect(Entity user, int attack, Entity enemy) {
        if (inReach(user, enemy)) {
            super.damaging(enemy, attack);
        }
    }
}