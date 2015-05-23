package kgs.towerdefence.tiles;

import java.awt.image.BufferedImage;
import kgs.towerdefence.graphics.Spritesheet;

public class TileManager {

    private Spritesheet tileSheet;

    public static final int TILE_RESOLUTION = 32;

    public static Tile TEST_TILE;

    public TileManager() {
        this.tileSheet = new Spritesheet("/tiles.png");

        TEST_TILE = new Tile(getTileImage(1), 1);
    }

    public BufferedImage getTileImage(int id) {
        return tileSheet.getSubimage(id, TILE_RESOLUTION);
    }
}
