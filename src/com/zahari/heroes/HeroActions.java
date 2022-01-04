package com.zahari.heroes;

import com.zahari.armors.*;
import com.zahari.dungeon.Dungeon;
import com.zahari.monsters.Monster;
import com.zahari.skills.Skill;

import java.util.Random;

public class HeroActions extends Hero implements Attackable, Upgradable {

    private Hero hero;
    private Dungeon dungeon;

    public HeroActions(Hero hero, Dungeon dungeon) {
        this.hero = hero;
        this.dungeon = dungeon;
    }

    @Override
    public void increaseDefense(int leveledUp) {
        if (leveledUp > 0) {
            double increasedDefensePoints = hero.getDefensePoints() + leveledUp * 1.5;
            hero.setDefensePoints(increasedDefensePoints);
        }
    }

    @Override
    public void increaseAttackPower(int leveledUp) {
        increasedWeaponDamage(leveledUp);
        hero.setDamagePoints(hero.getDamagePoints() + (leveledUp * 5.5));
    }

    @Override
    public void increaseStats(String type, int amount) {
        if (amount > 0) {
            switch (type) {
                case "Strength" -> {
                    hero.getStats().addStrength(amount);
                    hero.setDamagePoints(hero.getDamagePoints() + amount * 2.5);
                }
                case "Vitality" -> {
                    hero.getStats().addVitality(amount);
                    hero.setHealthPoints(hero.getHealthPoints() + amount * 5);
                }
                case "Intelligence" -> {
                    hero.getStats().addIntelligence(amount);
                    if (hero.getName().equals("Mage")) {
                        hero.setSkillCostUnit(hero.getSkillCostUnit() + amount * 5);
                    }
                }
                case "Dexterity" -> hero.getStats().addDexterity(amount);
                case "Agility" -> hero.getStats().addAgility(amount);
            }
        }
    }

    @Override
    public void levelUp() {
        if (hero.getLevel() < MAX_LEVEL) {
            hero.setLevel(hero.getLevel() + 1);
            hero.setAvailableStatPoints(hero.getAvailableStatPoints() + 4);
            equipArmor(hero.getLevel());
        }
    }

    @Override
    public void equipArmor(int level) {
        switch (level) {
            case 2 ->  {
                hero.setArmor(new Boots());
                hero.setDefensePoints(hero.getDefensePoints() + new Boots().getDefensePoints());
            }
            case 4 -> {
                hero.setArmor(new Gloves());
                hero.setDefensePoints(hero.getDefensePoints() + new Gloves().getDefensePoints());
            }
            case 6 -> {
                hero.setArmor(new Helmet());
                hero.setDefensePoints(hero.getDefensePoints() + new Helmet().getDefensePoints());
            }
            case 8 -> {
                hero.setArmor(new Leggings());
                hero.setDefensePoints(hero.getDefensePoints() + new Leggings().getDefensePoints());
            }
            case 10 -> {
                hero.setArmor(new Chest());
                hero.setDefensePoints(hero.getDefensePoints() + new Chest().getDefensePoints());
            }
        }
    }

    @Override
    public void attack(Monster monster) {
        if (monster != null) {
            monster.reduceHealth(hero.getDamagePoints());
        }
    }

    @Override
    public void attack(Monster monster, Skill skill) {
        monster.reduceHealth(hero.getDamagePoints() + skill.getDamage());
    }

    @Override
    public boolean isDead() {
        return hero.getHealthPoints() <= 0;
    }

    /**
     * This method is for test purposes.
     * Real implementation is not ready yet.
     * because increasing given stat by 0 or negative number is pointless.
     * This implementation does on cover negative numbers i.e. decrease given stat
     */
    public void upgradeAfterClearingDungeon(int leveledUp) {
        if (leveledUp <= 0) {
            return;
        }

        String randomStatType = getRandomStatType();
        increaseStats(randomStatType, hero.getAvailableStatPoints());
        hero.setAvailableStatPoints(0);

        increaseAttackPower(leveledUp);
        increaseDefense(leveledUp);
    }

    public void restoreHero(double restoredHealth, int restoredSkillCostUnit) {
        if (restoredHealth <= 0 || restoredSkillCostUnit <= 0) {
            return;
        }

        hero.setHealthPoints(restoredHealth);
        hero.setSkillCostUnit(restoredSkillCostUnit);
    }

    public void startDungeonWith(Hero hero) {
        if (!isHeroCompatibleWithDungeon() || hero == null) {
            return;
        }

        double restoredHealth = hero.getHealthPoints();
        int restoredSkillCostUnit = hero.getSkillCostUnit();
        int levelBeforeDungeon = hero.getLevel();
        int leveledUp = 0;

        for (Monster monster : dungeon.getMonsters()) {
            if (fightTillDie(hero, monster)) {
                break;
            }
            if (hero.getLevel() < Hero.MAX_LEVEL && hero.getLevel() < dungeon.getMaxLevel()) {
                levelUp();
            }
        }

        leveledUp = hero.getLevel() - levelBeforeDungeon;
        restoredHealth = restoredHealth  + (leveledUp * 25);

        if (hero.getName().equals("Mage")) {
            restoredSkillCostUnit = restoredSkillCostUnit + (leveledUp * 5);
        }

        restoreHero(restoredHealth, restoredSkillCostUnit);
        upgradeAfterClearingDungeon(leveledUp);
    }

    public boolean fightTillDie(Hero hero, Monster monster) {
        if (hero == null || monster == null) {
            return true;
        }

        do {
            attack(monster);
            monster.attack(hero);
        } while (!isDead() && !monster.isDead());

        return isDead();
    }

    private void increasedWeaponDamage(int leveledUp) {
        if (leveledUp <= 0) {
            return;
        }

        double currentWeaponDamage = hero.getWeapon().getDamage();
        hero.getWeapon().setDamage(currentWeaponDamage + 3.5);
    }

    /**
     * @return auto generated stat type as String. This implementation is for test purposes only.
     */
    private String getRandomStatType() {
        Random rnd = new Random();

        int max = 5;
        int rndNumber = rnd.nextInt(max);

        return switch (rndNumber) {
            case 0 -> "Strength";
            case 1 -> "Dexterity";
            case 2 -> "Vitality";
            case 3 -> "Intelligence";
            case 4 -> "Agility";
            default -> throw new IllegalStateException("Unexpected value: " + rndNumber);
        };
    }

    private boolean isHeroCompatibleWithDungeon() {
        return hero.getLevel() >= dungeon.getMinLevel() && hero.getLevel() <= dungeon.getMaxLevel();
    }
}
