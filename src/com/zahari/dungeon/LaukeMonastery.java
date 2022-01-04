package com.zahari.dungeon;

import com.zahari.monsters.Monster;
import com.zahari.monsters.laukemonastery_monsters.*;

import java.util.ArrayList;
import java.util.List;

public class LaukeMonastery extends Dungeon {

    public LaukeMonastery() {
        super("Lauke Monastery", 30, 60);
        this.setMonsters(initializeMonsters());
    }

    private List<Monster> initializeMonsters() {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Spider());
        monsters.add(new Tonken());
        monsters.add(new Specter());
        monsters.add(new MightSoul());
        monsters.add(new Mummy());

        return monsters;
    }
}
