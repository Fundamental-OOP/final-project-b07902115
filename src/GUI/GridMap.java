package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GridMap {
    private Image background;
    private ArrayList<Image> entity;

    GridMap(GrassType type){
        TilesetGrass tgrass = new TilesetGrass();
        background = tgrass.getImage(type);
        entity = new ArrayList<Image>();
    }

    public Image getImage() {
        BufferedImage finalImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = finalImage.createGraphics();
        g.drawImage(background, 0, 0, null);
        for(int i = 0; i < entity.size(); i++){
            g.drawImage(entity.get(i), 0, 0, null);
        }
        g.dispose();

        return (Image) finalImage;
    }

	public boolean hasEntity() {
		return this.entity != null;
	}

    public void setEntity(Image entity) {
        (this.entity).add(entity);
    }

    public void removeEntity(){
        this.entity = null;
    }

    public void clearEntity(){
        this.entity.clear();
    }
}
