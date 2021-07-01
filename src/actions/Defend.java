package actions;

import entities.Entity;
import states.Defending;

public class Defend extends Action {
    
    public Defend() {
        super("Defend", 5, 0, 0);
    }

    @Override
    public void effect(Entity user, int attack, Entity enemy) {
        user.setState(new Defending(user));
    }
}