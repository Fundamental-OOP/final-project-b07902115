package control;

import entities.*;
import utils.UI;
import utils.WindowInteractions;
import GUI.Window;
import actions.*;
import java.awt.Point;

public class Game {
    private UI ui;
    private Window window;
    private Entity hero;
    private Entity monster;
    
    public Game(UI ui, Window window, int height, int width) {
        this.ui = ui;
        this.window = window;
		
        this.hero = new Hero("Hero", 100, 100, 5, 10, ui);
		this.hero.addAction(new Defend());
		this.hero.addAction(new Heal());
		this.hero.addAction(new Poison());
		this.hero.addAction(new Stun());
		this.hero.setBoundary(height, width);
		this.hero.setLocation(new Point(5, 1));
		((WindowInteractions) ui).setHeroStats((Hero) hero);
		
        this.monster = new Monster("Monster", 200, 1000, 2, 10);
		this.monster.addAction(new Stun());
		this.monster.setBoundary(height, width);
		this.monster.setLocation(new Point(5, 5));
		((WindowInteractions) ui).setMonsterStats((Monster) monster);
		
    }

    public void start() {
		
        Entity active = hero;
        Entity passive = monster;
		
        while (!hero.isDead() && !monster.isDead()) {
            active.takeTurn(this.ui, passive);
            if (active == hero) {
                active = monster;
                passive = hero;
            }
            else {
                active = hero;
                passive = monster;
            }
        }
        ui.gameOver(!hero.isDead()); // win if hero is not dead
    }
}