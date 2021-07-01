package states;

import entities.Entity;

public class Normal extends State {
    public Normal(Entity affected, int countdown) {
        super(affected, countdown);
    }

    public Normal(Entity affected) {
        super(affected);
    }

    @Override
    public State update() {
        return this;
    }
}