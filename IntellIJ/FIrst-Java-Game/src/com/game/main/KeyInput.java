package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;


    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            //Here we switch the key code to determine which key has been pressed
            //and then we take the appropriate action

            if (handler.object.get(i).getId() == ID.Player) {
                if(key == KeyEvent.VK_W) up = true;
                else if(key == KeyEvent.VK_A) left = true;
                else if(key == KeyEvent.VK_S) down = true;
                else if(key == KeyEvent.VK_D) right = true;
            }
            if (key == KeyEvent.VK_ESCAPE) System.exit(1);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            //Here we switch the key code to determine which key has been pressed
            //and then we take the appropriate action
            if (handler.object.get(i).getId() == ID.Player) {
                if(key == KeyEvent.VK_W) up = false;
                else if(key == KeyEvent.VK_A) left = false;
                else if(key == KeyEvent.VK_S) down = false;
                else if(key == KeyEvent.VK_D) right = false;
            }
        }
    }

    public void update() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (handler.object.get(i).getId() == ID.Player) {
                if(up) tempObject.setVelY(-5);
                else if(left) tempObject.setVelX(-5);
                else if(down) tempObject.setVelY(5);
                else if(right) tempObject.setVelX(5);
            }
        }
    }
}
