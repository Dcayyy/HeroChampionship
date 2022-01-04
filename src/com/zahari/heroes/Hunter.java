package com.zahari.heroes;

import com.zahari.skills.HunterSkills;
import com.zahari.weapons.Bow;

public class Hunter extends Hero {

    public Hunter() {
        super("Hunter", 1500, 900, new HunterSkills(), new Bow());
    }
}
