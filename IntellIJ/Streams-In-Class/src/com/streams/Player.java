package com.streams;

import java.io.Serializable;

public class Player implements Serializable{
    public int health;
    public int mana;
    public boolean isAlive;

    public Player(int startHealth, int startMana) {
        health = startHealth;
        mana = startMana;
        isAlive = true;
    }

}
