package com.zahari.heroes;

import com.zahari.skills.RogueSkills;
import com.zahari.weapons.Daggers;

public class Rogue extends Hero {

    public Rogue() {
        super("Rogue", 1750, 200, new RogueSkills(), new Daggers());
    }
}
