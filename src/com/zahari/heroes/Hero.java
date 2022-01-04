package com.zahari.heroes;

import com.zahari.armors.*;
import com.zahari.skills.SkillSet;
import com.zahari.stats.Stats;
import com.zahari.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hero {

    public static final int MAX_LEVEL = 99;

    private String name;
    private double healthPoints;
    private int level;
    private int skillCostUnit;
    private double defensePoints;
    private double damagePoints;
    private int availableStatPoints;
    private Weapon weapon;
    private SkillSet skillset;
    private List<Armor> armors;
    private Stats stats;

    public Hero() { }

    public Hero(String name, double healthPoints, int skillCostUnit, SkillSet skillSet, Weapon weapon) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.skillCostUnit = skillCostUnit;
        this.level = 1;
        this.defensePoints = 0;
        this.damagePoints = 5 + weapon.getDamage();
        this.availableStatPoints = 0;
        this.skillset = skillSet;
        this.weapon = weapon;
        this.stats = new Stats();
        this.armors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public int getSkillCostUnit() {
        return skillCostUnit;
    }

    public int getLevel() {
        return level;
    }

    public double getDefensePoints() {
        return defensePoints;
    }

    public double getDamagePoints() {
        return damagePoints;
    }

    public Stats getStats() {
        return stats;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getAvailableStatPoints() {
        return availableStatPoints;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public void setSkillCostUnit(int skillCostUnit) {
        this.skillCostUnit = skillCostUnit;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void setDamagePoints(double damagePoints) {
        this.damagePoints = damagePoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAvailableStatPoints(int availableStatPoints) {
        this.availableStatPoints = availableStatPoints;
    }

    public void setArmor(Armor armor) {
        this.armors.add(armor);
    }

    public void reduceHealth(double amount) {
        this.healthPoints -= amount;
    }

    public void increaseHealth(int amount) {
        this.healthPoints += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return getName().equals(hero.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Hero {" +
                "\n name='" + name + '\'' +
                "\n health=" + healthPoints +
                "\n level=" + level +
                "\n defensePoints=" + defensePoints +
                "\n damagePoints=" + damagePoints +
                "\n weapon=" + weapon +
                "\n skillset=" + skillset +
                "\n armors=" + armors +
                "\n stats=" + stats +
                '}';
    }
}
