package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entities.Entity;

public class Window extends JFrame implements ActionListener{
    private final int unit = 32;
    private final int width = 1024;
    private final int height = 768;
    private final int delay = 200;
    private final String title = "Game";
    private GridMap[][] gridmap;
    private PaneGenerator paneGenerator;
    private HeroFigure hero;
    private BossFigure boss;
    private int stage = 0;
	private Timer timer = new Timer(delay, this);

    public Window(int mapHeight, int mapWidth){
		
        gridmap = new GridMap[mapHeight][mapWidth];
        this.hero = new HeroFigure();
        this.boss = new BossFigure();
		
        JPanel pane = new JPanel();
        paneGenerator = new PaneGenerator();
        paneGenerator.getInitialPane(pane, gridmap);
        this.setContentPane(pane);
        createWindow();
    }

    public void createWindow(){
        setSize(width, height);
        setTitle(title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

	/* Start/End Game */

    public void StartGame(){
		hero.setSprites();
		boss.setSprites();
        timer.start();
    }

    public void EndGame(String msg){
		timer.stop();
        JPanel newPane = new JPanel();
        paneGenerator.getEndPane(newPane, gridmap, msg);
        this.setContentPane(newPane);
        createWindow();
    }

	/* This Function is called by the timer */
	
	public void actionPerformed(ActionEvent e){
        clearAllEntity();
        JPanel newPane = new JPanel();
        Point hPos = hero.getPos();
        Point bPos = boss.getPos();

        for(int i = 0; i < boss.getWidth(); i++){
            for(int j = 0; j < boss.getHeight(); j++){
                gridmap[ (int) bPos.getX() + j ][ (int) bPos.getY() + i ].setEntity( boss.getSprite().getImage(i, j, stage) );
            }
        }
        for(int i = 0; i < hero.getWidth(); i++){
            for(int j = 0; j < hero.getHeight(); j++){
                gridmap[ (int) hPos.getX() + j ][ (int) hPos.getY() + i ].setEntity( hero.getSprite().getImage(i, j, stage) );
            }
        }

        paneGenerator.UpdatePane(newPane, gridmap);
        this.setContentPane(newPane);
        stage++;

        createWindow();
    }
	
	/* Map */

    public void clearAllEntity(){
        for(int i = 0; i < gridmap.length; i++){
            for(int j = 0; j < gridmap[i].length; j++){
                gridmap[i][j].clearEntity();
            }
        }
    }

	/* HUD */
	
    public void setStringToShow(String StringToShow){
        paneGenerator.setStringToShow(StringToShow);
    }
	
    public void setCurrentState(String currentState) {
        paneGenerator.setCurrentState(currentState);
    }
	
	/* Set HeroFigure Properites */
	
	public void setHUDHeroHPP(double heroHPP) {
		paneGenerator.setHeroHPP(heroHPP);
	}
	
	public void setHUDHeroSTA(int heroSTA) {
		paneGenerator.setHeroSTA(heroSTA);
	}
	
	public void setHeroPos(Point newPos) {
		hero.setPos(newPos);
	}
	
	public void setHeroSize(Point size) {
		hero.setHeight(size.x);
		hero.setWidth(size.y);
	}
	
	public void setHeroCurrentAction(String currentAction) {
		hero.setCurrentAction(currentAction);
	}
	
	/* Set BossFigure Properites */
	
	public void setHUDBossHPP(double bossHPP) {
		paneGenerator.setBossHPP(bossHPP);
	}
	
	public void setBossPos(Point newPos) {
		boss.setPos(newPos);
	}
	
	public void setBossCurrentAction(String currentAction) {
		boss.setCurrentAction(currentAction);
	}
	
	public void setBossSize(Point size) {
		boss.setHeight(size.x);
		boss.setWidth(size.y);
	}

}
