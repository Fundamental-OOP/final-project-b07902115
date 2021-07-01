package entities;

import states.*;
import actions.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
import java.lang.RuntimeException;
import utils.UI;
import utils.Toolkit;

public abstract class Entity {
    protected String name;
    protected HealthPoint hp;
    protected MagicPoint mp;
    protected Stamina sta;
    protected int attack;
    protected State state;
    protected Point location;
	protected Point size;
    protected Point hitLoc;
	protected Point hitSize;
    protected Point boundary;
	protected String figureAction;
    protected List<Action> availableActions;

    public Entity(String name, int hp, int mp, int sta, int attack) {
        this.name = name;
        this.hp = new HealthPoint(hp);
        this.mp = new MagicPoint(mp);
        this.sta = new Stamina(sta);
        this.attack = attack;
		this.state = new Normal(this);
        this.availableActions = new ArrayList<>();
        this.availableActions.add(new actions.Skip());
        this.availableActions.add(new actions.BasicAttack());
		this.location = new Point();
		setFigureAction("idle");
    }

	/* Getters */
	
	public String getStatus() {
		return String.format("%s HP: %d; loc: (%d, %d); state: %s",
			this.name,
			this.getHP(),
			this.location.x,
			this.location.y,
			this.state.toString()
		);
	}
	
    public State getState() {
        return this.state;
    }
	
	public int getHP() {
		return this.hp.getVal();
	}
	public double getHPP() {
		return this.hp.getPercentage();
	}
	
	public int getSTA() {
		return this.sta.getVal();
	}
	
	public Point getSize() {
		return this.size;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public Point calHitLocByNewPos(Point p) {
		int x = p.x + this.hitLoc.x;
		int y = p.y + this.hitLoc.y;
		return new Point(x, y);
	}
	
	public Point getHitLoc() {
		return calHitLocByNewPos(this.location);
	}
	
	public Point getHitSize() {
		return this.hitSize;
	}
	
	public String getFigureAction() {
		return this.figureAction;
	}
	
	public String getName() {
		return this.name;
	}

    public boolean isDead() {
        // Maybe do something when dead?
        return hp.getVal() <= 0;
    }

	/* Setters */
	
    public void setState(State state) {
        this.state = state;
    }
	
	public void setBoundary(int x, int y) {
		this.boundary = new Point(x, y);
	}
	
	public void setSize(int x, int y) {
		this.size = new Point(x, y);
	}
	
	public void setHitbox(int x, int y, int sizeX, int sizeY) {
		this.hitLoc = new Point(x, y);
		this.hitSize = new Point(sizeX, sizeY);
	}
	
	public void setLocation(Point newPoint) {
		if (outOfBounds(newPoint))
			throw new java.lang.RuntimeException("New location out of bounds");
		else
			this.location = newPoint;
	}
	
	public void setLocation(Point newPoint, Entity target) {
		
		int distance = Toolkit.calDistance(
			calHitLocByNewPos(newPoint),
			getHitSize(),
			target.getHitLoc(),
			target.getHitSize()
		);
		
		System.out.println(distance);
		if (outOfBounds(newPoint))
			throw new java.lang.RuntimeException("New location out of bounds");
		else if(distance == 0)
			throw new java.lang.RuntimeException("New location occupied");
		else
			this.location = newPoint;
	}
	
	public void setFigureAction(String newAction) {
		this.figureAction = newAction;
	}

    public void addAction(Action action) {
        this.availableActions.add(action);
    }

	/* Entity Actions */

    public void takeTurn(UI ui, Entity target) {
        this.state.takeTurn(ui, target);
    }

    public void readyPhase(UI ui) {
        this.state = this.state.update();
        this.sta.reset();
		System.out.printf("%s HP: %d %s\n", this.name, this.getHP(), this.location.toString());
    }

    public abstract void movePhase(UI ui, Entity target);
    public abstract void actionPhase(UI ui, Entity target);
    
    public void endingPhase(UI ui) {
    }

    public void takeDamage(int damage) {
        this.hp.modVal(-1*damage);
    }
	
	/* Private Functions */
	
	private boolean outOfBounds(Point newPoint) {
		if(newPoint.x + this.size.x >= this.boundary.x ||
		   newPoint.y + this.size.y >= this.boundary.y ||
		   newPoint.x < 0 || newPoint.y < 0) {
		   return true;
		}
		return false;
	}
}