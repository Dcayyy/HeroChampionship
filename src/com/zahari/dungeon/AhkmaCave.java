package com.zahari.dungeon;

import com.zahari.monsters.Monster;
import com.zahari.monsters.ahkmacave_monsters.Bear;
import com.zahari.monsters.ahkmacave_monsters.BloodSoul;
import com.zahari.monsters.ahkmacave_monsters.Imp;

import java.util.ArrayList;
import java.util.List;

public class AhkmaCave extends Dungeon {

    public AhkmaCave() {
        super("Ahkma Cave", 1, 30);
        this.setMonsters(initializeMonsters());
    }

    private List<Monster> initializeMonsters() {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Bear());
        monsters.add(new BloodSoul());
        monsters.add(new Imp());

        return monsters;
    }
}
