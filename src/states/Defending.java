package states;

import entities.Entity;
import utils.UI;

public class Defending extends State {
    public Defending(Entity affected) {
        super(affected, 0);
    }
    
    @Override
    public void takeDamage(int damage) {
        this.affected.takeDamage((int)(0.75 * damage));
    }
}