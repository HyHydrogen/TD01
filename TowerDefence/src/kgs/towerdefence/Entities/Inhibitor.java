package kgs.towerdefence.Entities;
import kgs.towerdefence.tiles.TileManager;
import java.awt.*;



public class Inhibitor {

    private Image image;

    public Inhibitor(Image image){
        this.image = image;
    }

    public int getWidth(){
        return image.getWidth(null);
    }

    public int getHeight(){
        return image.getHeight(null);
    }

    public void draw(Graphics g,int x, int y){
        g.drawImage(image,x,y,null);
    }

    public Image getSprite(int x, int y){
        getSprite(2,1);
        return image;
    }









}
