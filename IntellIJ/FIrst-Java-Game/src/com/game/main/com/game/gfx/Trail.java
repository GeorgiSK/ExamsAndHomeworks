package com.game.main.com.game.gfx;

import com.game.main.ID;
import com.game.main.GameObject;
import com.game.main.Handler;

import java.awt.*;

public class Trail extends GameObject{
    //Alpha represents the level of transparency (1 -> 0%; 0 -> 100%)
    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width, height;
    float life;


    public Trail(int x, int y, ID id, Color  color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    public void tick() {
        //If alpha is less than life, the trail is transparent
        if (alpha > life) alpha -= life - 0.0001f;
        else handler.removeObject(this);// And it gets removed from the game
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    public Rectangle getBounds() {
        return null;
    }
}
