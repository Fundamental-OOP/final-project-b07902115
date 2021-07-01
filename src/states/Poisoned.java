package states;

import entities.Entity;
import utils.UI;

public class Poisoned extends State {
    public Poisoned(Entity affected) {
        super(affected);
    }

    public Poisoned(Entity affected, int countdown) {
        super(affected, countdown);
    }

    @Override
    public void takeTurn(UI ui, Entity target) {
        super.affected.takeDamage(5);
        super.takeTurn(ui, target);
    }
}