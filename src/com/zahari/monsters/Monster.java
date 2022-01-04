package com.zahari.monsters;

import com.zahari.heroes.Hero;

public class Monster implements Attackable {

    private String name;
    private double health;
    private double attack;
    private int level;

    public Monster() { }

    public Monster(String name, double health, double attack, int level) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public int getLevel() {
        return level;
    }

    public void reduceHealth(double amount) {
        this.health -= amount;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public void attack(Hero hero) {
        hero.reduceHealth(this.getAttack() - hero.getDefensePoints());
    }
}
