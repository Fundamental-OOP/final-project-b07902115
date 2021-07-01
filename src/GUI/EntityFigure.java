package GUI;

import java.awt.*;
import javax.swing.*;

public class EntityFigure {
    private int height;
    private int width;
    private Sprite idle;
    private Sprite run;
    private Sprite attack;
    private Sprite die;
    private Point pos;
    private int[] range;
    private String currentAction;


    EntityFigure(){
        pos = new Point();
    }

	/* Getters */

    public Sprite getSprite() {
        switch (currentAction) {
            case "idle":
                return idle;
            case "run":
                return run;
            case "attack":
                return attack;
            case "die":
                return die;
            default:
                break;
        }
		throw new java.lang.RuntimeException("Figure action not found.");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getPos() {
        return pos;
    }

    public int[] getRange() {
        return range;
    }

	/* Setters */

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setIdle(Sprite idle) {
        this.idle = idle;
    }

    public void setRun(Sprite run) {
        this.run = run;
    }

    public void setAttack(Sprite attack) {
        this.attack = attack;
    }

    public void setDie(Sprite die) {
        this.die = die;
    }

    public void setPos(Point pos){
        this.pos = pos;
    }
	
    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction;
    }

    public void setRange(int[] range) {
        this.range = range;
    }
	
	/* Setup animated sprites for the figure */
	public void setSprites(String spritePath) {
		setSprites(spritePath, this.height, this.width, this.range);
	}
	
	public void setSprites(String spritePath, int height, int width, int[] range) {
		String idlePath   = String.format("%sIdle/"  , spritePath);
		String runPath    = String.format("%sRun/"   , spritePath);
		String attackPath = String.format("%sAttack/", spritePath);
		String diePath    = String.format("%sDie/"   , spritePath);
		
        setIdle  (new Sprite("idle"  , idlePath  , height, width, range));
        setRun   (new Sprite("run"   , runPath   , height, width, range));
        setAttack(new Sprite("attack", attackPath, height, width, range));
        setDie   (new Sprite("die"   , diePath   , height, width, range));
	}
}
