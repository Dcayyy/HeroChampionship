package com.zahari.skills;

import java.util.ArrayList;
import java.util.List;

public class SkillSet {

    private List<Skill> skills;

    public SkillSet() {
        this.skills = new ArrayList<>();
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "SkillSet{" +
                "skills=" + skills +
                '}';
    }
}
