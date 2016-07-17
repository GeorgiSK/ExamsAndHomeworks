package com.game.main;

import com.game.main.com.game.gfx.BufferedImageLoader;
import com.game.main.com.game.net.GameClient;
import com.game.main.com.game.net.GameServer;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = -473349850293143017L;
    public static final int WIDTH = 640, HEIGHT = (WIDTH / 12) * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private KeyInput keyInput;
    private HUD hud = new HUD();
    private Spawner spawner;

    //Network connection variables
    private GameClient socketClient;
    private GameServer socketServer;

    //Background and sprite sheet variables
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage explosion = null;

    public Game() {
        handler = new Handler();
        keyInput = new KeyInput(handler);
        this.addKeyListener(keyInput);
        new Window(WIDTH, HEIGHT, "First Java Game Beta", this);
        spawner = new Spawner(handler, hud);
    }

    public void init() {
        this.requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheet = loader.loadImage("/5.png");
            explosion = loader.loadImage("/explosion.png");
        }catch (IOException e) {
            e.printStackTrace();
        }

        handler.addObject(new Player(100, 100, ID.Player, this, handler));
        handler.addObject(new BasicEnemy(200, 43, ID.BasicEnemy, handler));
    }

    public synchronized void start() {
        //Creating a thread in which the game will run
        thread = new Thread(this);

        thread.start();
        running = true;

        /*socketServer.serverPrompt(socketServer, this);
        socketClient = new GameClient(this, "localhost");
        socketClient.start();
        socketClient.sendData("ping".getBytes());*/
    }
    public synchronized void stop() {
        //This gets executed when the game is closed
        try {
            //Joining the thread (closing it)
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running) {
                render();
                frames++;

                if (System.currentTimeMillis() - timer > 1_000) {
                    timer += 1_000;
                    System.out.println("FPS: " + frames);
                    frames = 0;
                }
            }else {
                stop();
            }
        }
    } //Game loop

    private void tick() {
        handler.tick();
        keyInput.update();
        hud.tick();
        spawner.tick();
    }

    private void render() {
        //Creating a buffer strategy
        //This is something that takes care of how things get printed in the window
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            //The triple buffer is most commonly used
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        ///////////////////////////////////////////

        g.setColor(Color.black);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        handler.render(g);
        hud.render(g);

        //////////////////////////////////////////
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
    public static int clamp(int var, int min, int max) {
        if (var >= max) return var = max;
        else if(var <= min)return var = min;
        else return var;
    }
    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }
}
