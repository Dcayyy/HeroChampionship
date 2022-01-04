package com.zahari.dungeon;

import com.zahari.monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private String name;
    private int minLevel;
    private int maxLevel;
    private List<Monster> monsters;

    public Dungeon(String name, int minLevel, int maxLevel) {
        this.name = name;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.monsters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
}
