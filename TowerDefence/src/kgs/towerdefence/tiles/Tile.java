package kgs.towerdefence.tiles;

import java.awt.image.BufferedImage;

public class Tile {
    private int tileId;

    private BufferedImage image;

    public Tile(BufferedImage image, int tileId) {
        this.tileId = tileId;

        this.image = image;
    }

    public int getImageId() {
        return tileId;
    }

    public BufferedImage getImage() {
        return image;
    }
}
