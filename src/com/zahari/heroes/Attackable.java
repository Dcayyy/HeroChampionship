package com.zahari.heroes;

import com.zahari.monsters.Monster;
import com.zahari.skills.Skill;

public interface Attackable {

    void attack(Monster monster);
    void attack(Monster monster, Skill skill);
    boolean isDead();

}
