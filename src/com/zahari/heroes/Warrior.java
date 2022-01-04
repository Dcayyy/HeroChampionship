package com.zahari.heroes;

import com.zahari.skills.WarriorSkills;
import com.zahari.weapons.Sword;

public class Warrior extends Hero {

    public Warrior() {
        super("Warrior", 2000, 100, new WarriorSkills(), new Sword());
    }

}
