package kgs.towerdefence.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import kgs.towerdefence.engine.math.Vector2f;
import kgs.towerdefence.graphics.GlobalRenderer;
import kgs.towerdefence.graphics.Spritesheet;
import kgs.towerdefence.graphics.Window;

public class Game extends Canvas implements Runnable {

    private Window gameScreen;

    private Thread gameThread;

    private boolean isRunning = false;

    private Spritesheet sheet;

    public final int width = 800, height = 600;
    public BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    public Game() {
        gameThread = new Thread(this);
        gameScreen = new Window("League of Legends Tower Defence", width, height);
        gameScreen.add(this);
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.start();

        int[] localPixels = new int[100 * 100];

        Arrays.fill(localPixels, Color.RED.getRGB());

        GlobalRenderer renderer  = new GlobalRenderer(game);
        renderer.render(localPixels, new Vector2f(15, 15));
    }

    public void start() {
        if (gameThread.isAlive())
            return;
        gameThread.start();

        setRunning(true);
    }

    public void stop() {
        if (gameThread == null && !isRunning())
            return;

        try {
            gameThread.join();
            setRunning(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void tick() {

    }

    public void render() {
        BufferStrategy strategy = this.getBufferStrategy();

        if (strategy == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics2D drawGraphics = (Graphics2D) strategy.getDrawGraphics();
        drawGraphics.drawImage(image, 0, 0, width, height, null);

        strategy.show();
        drawGraphics.dispose();

    }

    public void run() {
        int frames = 0, ticks = 0;
        double delta = 0, desiredTicks = 30.0;

        long lastTime = System.nanoTime(), timer = System.currentTimeMillis();

        double ns = 1000000000.0 / desiredTicks;

        while (isRunning()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
                ticks++;
            }

            render();
            frames++;


            if (System.currentTimeMillis() - 1000 > timer) {
                System.out.printf("Ticks: %s, Frames: %s\n", ticks, frames);
                ticks = 0;
                frames = 0;
                timer += 1000;
            }


            try {
                gameThread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stop();
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    public boolean isRunning() {
        return isRunning;
    }

}
