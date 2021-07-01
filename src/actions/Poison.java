package actions;

import entities.Entity;
import states.Poisoned;

public class Poison extends Action {

    public Poison() {
        super("Poison", 0.25, 10, 1);
    }

    @Override
    public void effect(Entity user, int attack, Entity enemy) {
        if (inReach(user, enemy)) {
            super.damaging(enemy, attack);
            enemy.setState(new Poisoned(enemy));
        }
    }
}