package kgs.towerdefence.graphics;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {

    private GraphicsEnvironment gEnvironment;
    private GraphicsDevice gDevice;

    private BufferedImage screenImage;
    private Canvas canvas;

    public Window(String title, int width, int height) {
        super(title);

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.screenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.gDevice = gEnvironment.getDefaultScreenDevice();
        this.setFullscreen(false);

        this.canvas = new Canvas();
    }

    public static void main(String[] args) {
        new Window("Test", 800, 600);
    }

    public void setFullscreen(boolean fullscreen) {
        if(!fullscreen) {
            gDevice.setFullScreenWindow(null);
        } else if(fullscreen && gDevice.isFullScreenSupported()){
            gDevice.setFullScreenWindow(this);
        } else {
            gDevice.setFullScreenWindow(null);
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
