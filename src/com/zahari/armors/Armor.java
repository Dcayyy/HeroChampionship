package com.zahari.armors;

public class Armor {
    private String name;
    private int levelDependency;
    private double defensePoints;

    public Armor() { }

    public Armor(String name, int levelDependency, double defensePoints) {
        this.name = name;
        this.levelDependency = levelDependency;
        this.defensePoints = defensePoints;
    }

    public int getLevelDependency() {
        return levelDependency;
    }

    public String getName() {
        return name;
    }

    public double getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", levelDependency=" + levelDependency +
                ", defensePoints=" + defensePoints +
                '}';
    }
}
