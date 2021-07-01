package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TilesetGrass {
    private final int unit = 32;
    private final String ImageAddress = "./graph/map/TilesetGrass.png";

    public Image getImage(GrassType type){
        BufferedImage image;
        try {
            image = ImageIO.read(new File(ImageAddress));
//          System.out.println("Height:" + image.getHeight());
//          System.out.println("Width" + image.getWidth());
            int[] pos = getPos(type);
            // 剪裁圖片 x, y, x+32, y+32
            image = image.getSubimage(pos[0], pos[1], this.unit, this.unit);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return image;
    }

    public int[] getPos(GrassType type){
        GrassType[][] map = new GrassType[][]
                {
                        {GrassType.grs01, GrassType.grs02, GrassType.grs03, GrassType.grs04, GrassType.flw01, GrassType.flw02, GrassType.flw03, GrassType.flw04},
                        {GrassType.grs05, GrassType.grs06, GrassType.grs07, GrassType.grs08, GrassType.flw05, GrassType.flw06, GrassType.flw07, GrassType.flw08},
                        {GrassType.grs09, GrassType.grs10, GrassType.grs11, GrassType.grs12, GrassType.flw09, GrassType.flw10, GrassType.flw11, GrassType.flw12},
                        {GrassType.grs13, GrassType.grs14, GrassType.grs15, GrassType.grs16, GrassType.flw13, GrassType.flw14, GrassType.flw15, GrassType.flw16},
                        {GrassType.st401, GrassType.st402, GrassType.st2r1, GrassType.st2l1, GrassType.st2d1, GrassType.st2d2, GrassType.st2d3, GrassType.st2d4},
                        {GrassType.st403, GrassType.st404, GrassType.st2r2, GrassType.st2l2, GrassType.st2u1, GrassType.st2u2, GrassType.st2u3, GrassType.st2u4},
                        {GrassType.st405, GrassType.st406, GrassType.st2r3, GrassType.st2l3, GrassType.st1ul, GrassType.st1ur, GrassType.st1dl, GrassType.st1dr},
                        {GrassType.st3ul, GrassType.st3ur, GrassType.st2r4, GrassType.st2l4, GrassType.st3dr, GrassType.st3dl, GrassType.gredl, GrassType.gredr},
                };

        int[] pos = {0, 0};
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(map[i][j] == type){
                    pos[0] = j * this.unit;
                    pos[1] = i * this.unit;
                }
            }
        }

        return pos;
    }
}
