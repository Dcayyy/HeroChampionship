package com.zahari.skills;

import java.util.ArrayList;
import java.util.List;

public class RogueSkills extends SkillSet {

    public RogueSkills() {
        this.setSkills(initializeSkills());
    }

    private List<Skill> initializeSkills() {
        List<Skill> skills = new ArrayList<>();

        skills.add(new Skill("Dancing Steel", 25, 15));
        skills.add(new Skill("Cheat Death", 50, 35));
        skills.add(new Skill("Killing Spree", 75, 50));
        skills.add(new Skill("Acrobatic Strikes", 30, 20));
        skills.add(new Skill("Hit and Run", 35, 25));

        return skills;
    }
}
