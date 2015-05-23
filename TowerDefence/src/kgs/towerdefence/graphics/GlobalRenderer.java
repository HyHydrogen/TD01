package kgs.towerdefence.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import kgs.towerdefence.core.Game;
import kgs.towerdefence.engine.math.Vector2f;

public class GlobalRenderer {

    private BufferedImage image;

    private Game game;

    private Vector2f panning;

    private int[] imageData;

    public GlobalRenderer(Game game) {
        this.game = game;
        this.panning = new Vector2f(0,0);
        imageData = ((DataBufferInt) game.image.getRaster().getDataBuffer()).getData();
    }

    public void render(int[] pixels, Vector2f renderTo) {
        int width = (int) Math.sqrt(pixels.length);

        Vector2f currentPanning = getPanning();

        int xOffset = (int) (renderTo.getX() - currentPanning.getX());
        int yOffset = (int) (renderTo.getY() - currentPanning.getY());
        for(int lX = 0; lX < width; lX++) {
            int currentX = xOffset + lX;

            if(currentX < 0 || currentX > game.getWidth())
                continue;

            for(int lY = 0; lY < width; lY++) {
                int currentY = yOffset + lY;

                if(currentY < 0 || currentY > game.getHeight())
                    continue;

                int renderPixel = pixels[lY * width + lX];

                if(renderPixel == 0)
                    continue;
                imageData[(int) ((currentY * game.width) + currentX)] = renderPixel;
            }
        }
    }

    public void setXPan(float xPan) {
        this.panning.setX(xPan);
    }

    public void setYPan(float yPan) {
        this.panning.setY(yPan);
    }

    public void setPan(Vector2f vec) {
        this.panning.set(vec);
    }

    public void addXPan(float xPan) {
        this.panning.add(new Vector2f(xPan, 0));
    }

    public void addYPan(float yPan) {
        this.panning.add(new Vector2f(0, yPan));
    }

    public void addPan(Vector2f vec) {
        this.panning.add(vec);
    }

    public Vector2f getPanning() {
        return panning;
    }

}
