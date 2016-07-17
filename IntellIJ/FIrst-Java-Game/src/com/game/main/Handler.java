package com.game.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        //This loop goes through all the objects in the game
        for (int i = 0; i < object.size(); i++) {
            //Gets them and saves their reference to the variable tempObject
            GameObject tempObject = object.get(i);

            //And initiates their tick method so their fields get updated every time the handler.tick() method gets initiated
            tempObject.tick();

            tempObject.setX(Game.clamp(tempObject.getX(), 0, Game.WIDTH - 35));
            tempObject.setY(Game.clamp(tempObject.getY(), 0, Game.HEIGHT - 60));
        }


    }
    public void render(Graphics g) {
        //This loop goes through all the objects in the game
        for (int i = 0; i < object.size(); i++) {
            //Gets them and saves their reference to the variable tempObject
            GameObject tempObject = object.get(i);

            //And invokes their render() method so any new changes on their rendering (graphics) get taken into account
            tempObject.render(g);
        }
    }

    //This method has to be used when adding new objects to the game or else they will not be dynamic(won't change color,speed etc..)
    //This method adds an object to the handler list
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    //This method removes an object from the object list in the handler class
    //When an object is removed from the list, his tick and render method are no more getting updated in every frame
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
