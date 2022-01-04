package com.zahari.heroes;


public interface Upgradable {

    /**
     * This method increase hero defense
     * Increase hero defense if amount is > 0
     * @param leveledUp is a how many levels a hero has leveled up after completion of the dungeon
     */
    void increaseDefense(int leveledUp);

    /**
     * This method increase hero attack power
     * The implementation is for increasing hero attack power by given amount > 0
     * @param leveledUp is a how many levels a hero has leveled up after completion of the dungeon
     */
    void increaseAttackPower(int leveledUp);

    /**
     * This method increase stats of currently used hero with automated methods which
     * generates random type and using all available statPoints for only one stat
     * @param type is used to determine which stat to be increased
     * @param amount is used to determine how much to increase given stat type
     */
    void increaseStats(String type, int amount);

    /**
     * levelUp method is called only when given hero kill a monster
     */
    void levelUp();

    /**
     * The implementation of equipArmor(int level) is for equipping the hero with given
     * armor if he met the level requirement
     * The method is called only when the dungeon is over
     * @param level is used to determine which armor to equip the hero after completing the dungeon
     */
    void equipArmor(int level);
}
