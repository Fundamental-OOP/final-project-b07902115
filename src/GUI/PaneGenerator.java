package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class PaneGenerator {
    private double HeroHPP = 0.6;
    private int HeroSTA = 10;
    private double BossHPP = 0.85;
    private String CurrentState = "Normal"; 
    private String StringToShow = "String to show";

    public void getInitialPane(Container pane, GridMap[][] gridmap) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GrassType[][] map = new GrassType[][] //32*24
                {   //             1,               2,               3,               4,               5,               6,               7,               8,               9,              10,              11,              12,              13,              14,              15,              16,              17,              18,              19,              20,              21,              22,              23,              24,              25,              26,              27,              28,              29,              30,              31,              32,
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st3dr, GrassType.st3dl, GrassType.st2d1, GrassType.st2d1, GrassType.st2d1, GrassType.st2d1, GrassType.st2d1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st3ur, GrassType.st3ul, GrassType.st2u1, GrassType.st2u1, GrassType.st2u1, GrassType.st2u1, GrassType.st2u1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2d1, GrassType.st2d1, GrassType.st2d1, GrassType.st2d1, GrassType.st3dr, GrassType.st3dl, GrassType.st2d1, GrassType.st2d1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2u1, GrassType.st2u1, GrassType.st2u1, GrassType.st2u1, GrassType.st3ur, GrassType.st3ul, GrassType.st2u1, GrassType.st2u1, GrassType.st1ul, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st1ul, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st3dr, GrassType.st3dl, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st3dl, GrassType.st2d1, GrassType.st2d1, GrassType.st2d1, GrassType.st2d1, GrassType.grs01, GrassType.st3dr, GrassType.st401, GrassType.st401, GrassType.st3dl, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st3ul, GrassType.st2u1, GrassType.st2u1, GrassType.st2u1, GrassType.st1ul, GrassType.grs01, GrassType.st3ur, GrassType.st401, GrassType.st401, GrassType.st3ul, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st3ur, GrassType.st3ul, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st1dr, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01},
                    {GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.st2r1, GrassType.st2l1, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01, GrassType.grs01}
                };

        randomize(map);

        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                GridMap temp = new GridMap(map[j][i]);
                ImageIcon img = new ImageIcon(temp.getImage());
                JLabel grid = new JLabel(img);
                c.gridx = i;
                c.gridy = j;

                gridmap[j][i] = temp;
                pane.add(grid, c);
            }
        }

        addText(pane, "Press any key to start", 10, 21, 10, 1.5);
        addText(pane, "Made by B07902037, B07902039, B07902115.", 5, 22, 20, 1.5);
    }

	/* Update Pane */
    
    public void UpdatePane(Container pane, GridMap[][] gridmap){
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for(int i = 0; i < gridmap.length; i++){
            for(int j = 0; j < gridmap[i].length; j++){
                ImageIcon img = new ImageIcon(gridmap[i][j].getImage());
                JLabel grid = new JLabel(img);
                c.gridx = j;
                c.gridy = i;

                pane.add(grid, c);
            }
        }

        addText(pane, "Boss's Hp", 1, 21, 4, 1.5);
        addBar(pane, BossHPP, 5, 21, 23, 1.5);
        addText(pane, "Hero's Hp", 1, 22, 4, 1.5);
        addBar(pane, HeroHPP, 5, 22, 8, 1.5);
        addText(pane, "STA remain:  " + HeroSTA, 15, 22, 6, 1.5);
        addText(pane, "State:  " + CurrentState, 21, 22, 8, 1.5);
        addText(pane, StringToShow, 0, 23, 32, 1.5);
    }
	
    public void getEndPane(Container pane, GridMap[][] gridmap, String msg){
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                ImageIcon img = new ImageIcon(gridmap[j][i].getImage());
                JLabel grid = new JLabel(img);
                c.gridx = i;
                c.gridy = j;

                pane.add(grid, c);
            }
        }

        addText(pane, msg, 10, 21, 10, 1.5);
        addText(pane, "Thanks for playing.", 10, 22, 10, 1.5);
    }

	/* Setter */
	
    public void setBossHPP(double bossHPP) {
        BossHPP = bossHPP;
    }

    public void setHeroHPP(double heroHPP) {
        HeroHPP = heroHPP;
    }

    public void setHeroSTA(int heroSTA) {
        HeroSTA = heroSTA;
    }
	
    public void setCurrentState(String currentState) {
        CurrentState = currentState;
    }

    public void setStringToShow(String stringToShow) {
        StringToShow = stringToShow;
    }

	/* Draw HUD */

    public void addBar(Container pane, Double per, int x, int y, int w, double h){
        GridBagConstraints c = new GridBagConstraints();
        BufferedImage HB;
        HB = drawBar(per, w);
        ImageIcon img = new ImageIcon(HB);
        JLabel HBLabel = new JLabel(img);
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.weighty = h;
        pane.add(HBLabel, c);
    }
	
    public BufferedImage drawBar(double health, int width){
        BufferedImage HealthBar = new BufferedImage(32*width, 32, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = HealthBar.createGraphics();
        Rectangle2D r = new Rectangle2D.Double(0, 0, 32*width, 32);
        g.setColor(Color.BLACK);
        g.draw(r);
        Rectangle2D r2 = new Rectangle2D.Double(1, 1, 32*width*health, 31);
        g.setColor(Color.RED);
        g.fill(r2);
        return HealthBar;
    }

    public void addText(Container pane, String msg, int x, int y, int w, double h){
        GridBagConstraints c = new GridBagConstraints();
        JLabel textLabel = new JLabel();
        textLabel.setText(msg);
		textLabel.setFont(new Font("", Font.PLAIN, 20));
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.weighty = h;
        pane.add(textLabel, c);
    }
	// public void addText(Container pane, String msg, int x, int y, int w, double h){
    //     GridBagConstraints c = new GridBagConstraints();
    //     JLabel textLabel = new JLabel();
    //     textLabel.setText(msg);
    //     textLabel.setFont(new Font("", Font.PLAIN, 24));
    //     c.gridx = x;
    //     c.gridy = y;
    //     c.gridwidth = w;
    //     c.weighty = h;
    //     pane.add(textLabel, c);
    // }
	
    public void randomize(GrassType[][] map){
        Random rand = new Random();
        GrassType[] grs = new GrassType[]{
                GrassType.grs01, GrassType.grs02, GrassType.grs03, GrassType.grs04,
                GrassType.grs05, GrassType.grs06, GrassType.grs07, GrassType.grs08,
                GrassType.grs09, GrassType.grs10, GrassType.grs11, GrassType.grs12,
                GrassType.grs13, GrassType.grs14, GrassType.grs15, GrassType.grs16

        };
        GrassType[] flw = new GrassType[]{
                GrassType.flw01, GrassType.flw02, GrassType.flw03, GrassType.flw04,
                GrassType.flw05, GrassType.flw06, GrassType.flw07, GrassType.flw08,
                GrassType.flw09, GrassType.flw10, GrassType.flw11, GrassType.flw12,
                GrassType.flw13, GrassType.flw14, GrassType.flw15, GrassType.flw16
        };
        GrassType[] st4 = new GrassType[]{
                GrassType.st401, GrassType.st402, GrassType.st403, GrassType.st404,
                GrassType.st405, GrassType.st406
        };
        GrassType[] st2r = new GrassType[]{
                GrassType.st2r1, GrassType.st2r2, GrassType.st2r3, GrassType.st2r4
        };
        GrassType[] st2l = new GrassType[]{
                GrassType.st2l1, GrassType.st2l2, GrassType.st2l3, GrassType.st2l4
        };
        GrassType[] st2u = new GrassType[]{
                GrassType.st2u1, GrassType.st2u2, GrassType.st2u3, GrassType.st2u4
        };
        GrassType[] st2d = new GrassType[]{
                GrassType.st2d1, GrassType.st2d2, GrassType.st2d3, GrassType.st2d4
        };

        for(int i = 0; i < 32; i++){
            for(int j = 0; j< 24; j++){
                if(map[j][i] == GrassType.grs01){
                    int x = rand.nextInt(4);
                    if(x == 0){
                        x = rand.nextInt(16);
                        map[j][i] = flw[x];
                    }
                    else{
                        x = rand.nextInt(16);
                        map[j][i] = grs[x];
                    }
                }
                else if(map[j][i] == GrassType.st401){
                    int x = rand.nextInt(6);
                    map[j][i] = st4[x];
                }
                else if(map[j][i] == GrassType.st2r1){
                    int x = rand.nextInt(4);
                    map[j][i] = st2r[x];
                }
                else if(map[j][i] == GrassType.st2l1){
                    int x = rand.nextInt(4);
                    map[j][i] = st2l[x];
                }
                else if(map[j][i] == GrassType.st2u1){
                    int x = rand.nextInt(4);
                    map[j][i] = st2u[x];
                }
                else if(map[j][i] == GrassType.st2d1){
                    int x = rand.nextInt(4);
                    map[j][i] = st2d[x];
                }
            }
        }
    }
}
