package utils;

import java.util.List;
import actions.Action;
import GUI.Window;

public interface UI {

	public void setWindow(Window window);
    public Direction getMove();
    public Action getAction(List<Action> avaliabaleActions);
    public void gameOver(boolean won);
    public void showInfo(String information);
}