package com.zahari.gameplay;

import com.zahari.dungeon.AhkmaCave;
import com.zahari.dungeon.Dungeon;
import com.zahari.dungeon.LaukeMonastery;
import com.zahari.dungeon.Ronelia;
import com.zahari.gamesave.GameSave;
import com.zahari.heroes.*;

public class GamePlay {

    public static void main(String[] args) {
        // Everything work till now
        // Need to add comments on methods
        // Then I should unit test the game

        GameSave gameSave = new GameSave();

        // Hero hero = gameSave.load("Mage");
        Hero warrior = new Warrior();
        Hero rogue = gameSave.load("Rogue");

        Dungeon ahkmaCave = new AhkmaCave();
        Dungeon laukeMonastery = new LaukeMonastery();
        Dungeon ronelia = new Ronelia();

        HeroActions heroActions = new HeroActions(rogue, ronelia);

        while (rogue.getLevel() >= ronelia.getMinLevel() && rogue.getLevel() < ronelia.getMaxLevel()) {
            System.out.println(rogue.getLevel());
            heroActions.startDungeonWith(rogue);
        }

        gameSave.save(rogue);

    }
}
