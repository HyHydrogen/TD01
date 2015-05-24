package kgs.towerdefence.Entities;

import kgs.towerdefence.tiles.TileManager;

import java.awt.*;

public class Nexus {
    private Image image;

    public Nexus(Image image){
        this.image = image;
    }

    public int getWidth(){
        return image.getWidth(null);
    }

    public int getHeight(){
        return image.getWidth(null);
    }

    public void draw(Graphics g, int x, int y){
        g.drawImage(image,x,y,null);
    }

    public Image getSprite (int x, int y){
        getSprite(3,2);
        return image;
    }
}
