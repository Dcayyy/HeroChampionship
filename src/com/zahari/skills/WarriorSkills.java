package com.zahari.skills;

import java.util.ArrayList;
import java.util.List;

public class WarriorSkills extends SkillSet {

    public WarriorSkills() {
        this.setSkills(initializeSkills());
    }

    public List<Skill> initializeSkills() {
        List<Skill> skills = new ArrayList<>();

        skills.add(new Skill("Furious Slash", 25, 7.5));
        skills.add(new Skill("Storm Bolt", 30, 9));
        skills.add(new Skill("Bladestorm", 50, 17));
        skills.add(new Skill("Meat Cleaver", 35, 11.5));
        skills.add(new Skill("Massacre", 15, 5));

        return skills;
    }
}
