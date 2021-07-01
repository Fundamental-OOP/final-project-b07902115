package GUI;

import java.awt.*;
import javax.swing.*;
import entities.Entity;

public class HeroFigure extends EntityFigure {
    public HeroFigure(){
        setRange(new int[] {0, 0, 1, 1});
    }
	
	/* Setup animated sprites for the figure */
	public void setSprites() {
		setSprites("./graph/hero/");
	}
}
