package com.game.main;
import com.game.main.com.game.gfx.Trail;

import java.awt.*;

public class BasicEnemy extends GameObject {
    private  Handler handler;


    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 5;
        velY = 5;
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
        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.5f, handler));
    }

    public void render(Graphics g) {
        int animX = (int) (Math.sin(System.currentTimeMillis() % 2000.0 / 1000 * Math.PI * 2) * 150);
        int animY = (int) (Math.cos(System.currentTimeMillis() % 2000.0 / 1000 * Math.PI * 2) * 150);
        int finalX = Game.clamp(x + animX, 0, Game.WIDTH - 20);
        int finalY = Game.clamp(y + animY, 0, Game.HEIGHT - 60);
        g.setColor(Color.red);
        g.fillRect(finalX, finalY, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
}
