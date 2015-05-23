package kgs.towerdefence.graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Spritesheet {
    private BufferedImage image;
    private String imagePath;

    public Spritesheet(String path) {
        this.image = null;
        this.imagePath = path;

        this.loadImage();
    }

    public void loadImage() {
        if (imagePath == null)
            return;

        try {
            this.image = ImageIO.read(getClass().getResource(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public BufferedImage getSubimage(int tile, int tileWidth) {
        int xTile = (tile - 1) % 8;
        int yTile = (int) Math.floor((tile - 1) / 8);
        return image.getSubimage(xTile * tileWidth, yTile * tileWidth, tileWidth, tileWidth);
    }




}
