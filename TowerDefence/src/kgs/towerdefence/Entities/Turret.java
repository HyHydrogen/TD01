package kgs.towerdefence.Entities;

import kgs.towerdefence.tiles.TileManager;

import java.awt.*;

public class Turret extends Structure{
    private Image image;



    public Turret(Image image){
        this.image = image;
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public void draw(Graphics g,int x, int y) {
        g.drawImage(image,x,y,null);
    }

    public Image getSprite(int x, int y){
        getSprite(1, 4);
        return image;
    }













}

