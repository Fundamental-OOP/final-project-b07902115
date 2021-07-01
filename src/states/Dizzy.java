package states;

import entities.Entity;
import utils.UI;

public class Dizzy extends State {
    public Dizzy(Entity affected) {
        super(affected);
    }

    public Dizzy(Entity affected, int countdown) {
        super(affected, countdown);
    }

    @Override
    public void takeTurn(UI ui, Entity entity) {
		System.out.println("Skipped");
        this.affected.readyPhase(ui);
		System.out.println("Ending");
        this.affected.endingPhase(ui);
    }
}