package com.zahari.skills;

import java.util.ArrayList;
import java.util.List;

public class HunterSkills extends SkillSet {

    public HunterSkills() {
        this.setSkills(initializeSkills());
    }

    public List<Skill> initializeSkills() {
        List<Skill> skills = new ArrayList<>();

        skills.add(new Skill("Explosive Shot", 350, 20));
        skills.add(new Skill("Binding Show", 150, 9.5));
        skills.add(new Skill("Steady Focus", 270, 15.5));
        skills.add(new Skill("Kill Shot", 400, 25));
        skills.add(new Skill("Black Arrow", 175, 12));

        return skills;
    }

}
