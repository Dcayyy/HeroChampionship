package com.zahari.weapons;

public class Weapon {
    private String name;
    private double damage;

    public Weapon() {  }

    public Weapon(String name, double damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return this.name + " has damage " + this.damage;
    }
}
