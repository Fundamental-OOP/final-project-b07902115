package utils;

import java.awt.Point;
import entities.Hero;
import entities.Monster;
import GUI.Window;

public interface WindowInteractions {
	public void setStringToShow(String information);
	public void setHeroStats(Hero hero);
	public void setMonsterStats(Monster monster);
}