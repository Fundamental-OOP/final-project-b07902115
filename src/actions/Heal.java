package actions;

import entities.Entity;

public class Heal extends Action {
    
    public Heal() {
        super("Heal", 5, 0, 0);
    }

    @Override
    public void effect(Entity user, int attack, Entity target) {
        user.takeDamage(-10);
    }
}