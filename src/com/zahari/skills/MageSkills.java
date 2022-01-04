package com.zahari.skills;

import java.util.ArrayList;
import java.util.List;

public class MageSkills extends SkillSet {

    public MageSkills() {
        this.setSkills(initializeSkills());
    }

    private List<Skill> initializeSkills() {
        List<Skill> skills = new ArrayList<>();

        skills.add(new Skill("Scorch", 350, 25));
        skills.add(new Skill("Ice Flows", 500, 55));
        skills.add(new Skill("Frost Bomb", 400, 45));
        skills.add(new Skill("Fireball", 250, 20));
        skills.add(new Skill("Rune of Power", 300, 25));

        return skills;
    }
}
