package GUI;

import java.awt.*;
import javax.swing.*;
import entities.Entity;

public class BossFigure extends EntityFigure {
    public BossFigure(){
        setRange(new int[] {12, 4, 6, 8});
    }
	
	/* Setup animated sprites for the figure */
	public void setSprites() {
		setSprites("./graph/boss/");
	}
}
