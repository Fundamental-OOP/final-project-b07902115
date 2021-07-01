package GUI;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
    private final int unit = 32;
    private final int height;
    private final int width;
    private final int[] range;
    private String  name;
    private ArrayList<Image>[][] spriteSheet;

    Sprite(String dname, String address, int dheight, int dwidth, int[] drange){
        name = dname;
        height = dheight;
        width = dwidth;
        range = drange;
        spriteSheet = new ArrayList[width][height];
//      System.out.println("height " + height + " width " +  width);
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                spriteSheet[i][j] = new ArrayList<Image>();
            }
        }
        loadImage(address);
    }

    public void loadImage(String address){
        BufferedImage image;
        int x = 1;
        while(true){
            File file = new File(address + String.format("%2d", x).replace(" ", "0") + ".png");
            try {
                image = ImageIO.read(file);
//              System.out.println("Height:" + image.getHeight());
//              System.out.println("Width" + image.getWidth());

                image = reshape(image);
//              System.out.println("Height:" + image.getHeight());
//              System.out.println("Width" + image.getWidth());

//              addFrame(image);

                for(int i = 0; i < width; i++){
                    for(int j = 0; j < height; j++){
//                      System.out.println("x " + i*unit + " y " + j*unit);
                        BufferedImage newImage = image.getSubimage(i*unit, j*unit, unit, unit);
                        spriteSheet[i][j].add(newImage);
                    }
                }
            } catch (IOException ex) {
//              ex.printStackTrace();
                break;
            }
            x++;
        }
    }
	
	public BufferedImage addFrame(BufferedImage image){
        Graphics2D g = image.createGraphics();
        int x = range[0], y = range[1], w = range[2], h = range[3];
        Rectangle2D r = new Rectangle2D.Double(x*unit, y*unit, w*unit-1, h*unit-1);
        g.setColor(Color.RED);
        g.draw(r);
        return image;
    }

    public BufferedImage reshape(Image image){
        Image img = image.getScaledInstance(width * unit, height * unit, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(width * unit, height * unit, BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = newImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return newImage;
    }

    public Image getImage(int x, int y, int s){
//      System.out.println("ask for " + name + "'s sprite " + s % spriteSheet[x][y].size());
        return spriteSheet[x][y].get((s % spriteSheet[x][y].size()));
    }
}
