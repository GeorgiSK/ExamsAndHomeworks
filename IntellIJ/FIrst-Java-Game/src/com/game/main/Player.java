package com.game.main;
import com.game.main.com.game.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private BufferedImage player;
    Handler handler;

    public Player(int x, int y, ID id, Game game, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        player = ss.grabImage(1, 1, 98, 171);
    }

    public void tick() {
        x += velX;
        y += velY;

        collision();
    }

    public void render(Graphics g) {
        //int anim = (int) (Math.sin(System.currentTimeMillis() % 2000.0 / 2000 * Math.PI * 5) * 20);
        //int anim1 = (int) (Math.cos(System.currentTimeMillis() % 2000.0 / 500 * Math.PI * 2) * 20);
        //g.setColor(Color.white);
        //g.fillRect(x + anim, y + anim1, 32, 32);
        //g.fillRect(x, y, 32, 32);
        //g.drawImage(player,x ,y, null);
        g.drawImage(player, x, y, 60, 100, null);

    }

    private void collision() {
        //This loop goes through all objects in the game
        for (int i = 0; i < handler.object.size(); i++) {
            //Sets their reference to tempObject
            GameObject tempObject = handler.object.get(i);
            //If thee current object is an enemy
            if (tempObject.getId() == ID.BasicEnemy) {
                //And it collides with the player
                if (getBounds().intersects(tempObject.getBounds())) {
                    //The player loses 2 health
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
