package com.zahari.stats;

public class Stats {

    private int strength;
    private int dexterity;
    private int vitality;
    private int intelligence;
    private int agility;

    public Stats() { }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getVitality() {
        return vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void addStrength(int amount) {
        this.strength += amount;
    }

    public void addDexterity(int amount) {
        this.dexterity += amount;
    }

    public void addVitality(int amount) {
        this.vitality += amount;
    }

    public void addIntelligence(int amount) {
        this.intelligence += amount;
    }

    public void addAgility(int amount) {
        this.agility += amount;
    }

    public void resetStat() {
        this.strength = 0;
        this.dexterity = 0;
        this.vitality = 0;
        this.intelligence = 0;
        this.agility = 0;
    }

    @Override
    public String toString() {
        return "\n  Strength: " + this.strength +
                "\n  Dexterity: " + this.dexterity +
                "\n  Vitality: " + this.vitality +
                "\n  Intelligence: " + this.intelligence  +
                "\n  Agility: " + this.agility;

    }
}
