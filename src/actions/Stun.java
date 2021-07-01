package actions;

import entities.Entity;
import states.Dizzy;

public class Stun extends Action {
    
    public Stun() {
        super("Stun", 0.25, 10, 1);
    }

    @Override
    public void effect(Entity user, int attack, Entity enemy) {
        if (inReach(user, enemy)) {
            super.damaging(enemy, attack);
            enemy.setState(new Dizzy(enemy));
        }
    }
}