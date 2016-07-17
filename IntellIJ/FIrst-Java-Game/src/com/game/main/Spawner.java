package com.game.main;

public class Spawner {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            /////////////////////////////
            //Write conditions for mob spawning here

            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(15, 43, ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(150, 43, ID.BasicEnemy, handler));
            }else if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(100, 43, ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(200, 43, ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(85, 22, ID.FastEnemy, handler));
            }else if (hud.getLevel() == 4) {
                handler.addObject(new BasicEnemy(330, 43, ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(77, 43, ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(41, 79, ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(23, 99, ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(85, 22, ID.FastEnemy, handler));
            }
            /////////////////////////////
        }
    }


}
