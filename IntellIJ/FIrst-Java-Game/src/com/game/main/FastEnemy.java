package com.game.main;
import com.game.main.com.game.gfx.Trail;

import java.awt.*;

public class FastEnemy extends GameObject {
    private  Handler handler;


    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 10;
        velY = 10;
    }

    public void tick() {
        x += velX;
        y += velY;

        //This reverses direction after hitting the wall
        if (y <= 0 || y >= Game.HEIGHT - 64) velY *= - 1;
        if (x <= 0 || x >= Game.WIDTH - 32) velX *= - 1;
        //int animX = (int) (Math.sin(System.currentTimeMillis() % 2000.0 / 1000 * Math.PI * 2) * 150);
        //int animY = (int) (Math.cos(System.currentTimeMillis() % 2000.0 / 1000 * Math.PI * 2) * 150);
        //Adding a trail effect object
        handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16, 16, 0.4f, handler));
    }

    public void render(Graphics g) {
        //int animX = (int) (Math.sin(System.currentTimeMillis() % 2000.0 / 1000 * Math.PI * 2) * 150);
        //int animY = (int) (Math.cos(System.currentTimeMillis() % 2000.0 / 1000 * Math.PI * 2) * 150);
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
}
