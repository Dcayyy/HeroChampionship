package com.zahari.dungeon;

import com.zahari.monsters.Monster;
import com.zahari.monsters.ronelia_monsters.*;

import java.util.ArrayList;
import java.util.List;

public class Ronelia extends Dungeon {

    public Ronelia() {
        super("Ronelia", 60, 99);
        this.setMonsters(initializeMonsters());
    }

    private List<Monster> initializeMonsters() {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Demon());
        monsters.add(new Dragon());
        monsters.add(new Golem());
        monsters.add(new Witch());
        monsters.add(new GlacialDragon());

        return monsters;
    }
}
