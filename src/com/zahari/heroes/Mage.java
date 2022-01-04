package com.zahari.heroes;

import com.zahari.skills.MageSkills;
import com.zahari.weapons.Staff;

public class Mage extends Hero {

    public Mage() {
        super("Mage", 1350, 1500, new MageSkills(), new Staff());
    }
}
