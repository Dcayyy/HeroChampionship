package com.zahari.skills;

public class Skill {

    private String name;
    private int cost;
    private double damage;

    public Skill(String name, int cost, double damage) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public double getDamage() {
        return damage;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "\n Skill {" +
                "\n  name='" + name + '\'' +
                "\n  cost=" + cost +
                "\n  damage=" + damage +
                '}';
    }
}
