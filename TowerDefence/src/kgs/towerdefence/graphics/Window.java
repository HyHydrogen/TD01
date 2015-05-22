package kgs.towerdefence.graphics;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends Canvas {

    private JFrame frame;

    private Window(String title, int width, int height) {
        frame = new JFrame(title);
        getFrame().setMinimumSize(new Dimension(width, height));
        getFrame().setMaximumSize(new Dimension(width, height));
        getFrame().setPreferredSize(new Dimension(width, height));
    }

    public void displayScreen() {

    }

    public JFrame getFrame() {
        return frame;
    }
}
