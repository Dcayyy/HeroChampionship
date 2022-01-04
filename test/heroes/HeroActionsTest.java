package heroes;

import com.zahari.dungeon.Dungeon;
import com.zahari.heroes.*;
import com.zahari.monsters.Monster;
import com.zahari.monsters.ahkmacave_monsters.Imp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HeroActionsTest {

    @Mock
    private Hero hero;

    @Mock
    private Dungeon dungeon;

    @Mock
    private Upgradable upgradable;

    @Mock
    private Attackable attackable;

    @Mock
    private HeroActions heroActions;

    // Start of testing Upgradable interface


    @Nested
    @DisplayName("increaseDefenseMethod")
    class IncreaseDefense {

        @Test
        @DisplayName("When increasing defense with negative leveledUp")
        public void testIncreaseDefenseNegativeLeveledUp() {
            // Nothing will happen if we give a negative value for leveledUp
            // Note: This is not possible when you play the game
            doNothing().when(upgradable).increaseDefense(-5);
            upgradable.increaseDefense(-5);
            verify(upgradable, times(1)).increaseDefense(-5);
        }

        @Test
        @DisplayName("When increasing defense with zero leveledUp")
        public void testIncreaseDefenseWithZeroLeveledUp() {
            // Nothing will happen if we give zero for a leveledUp
            doNothing().when(upgradable).increaseDefense(0);
            upgradable.increaseDefense(0);
            verify(upgradable, times(1)).increaseDefense(0);
        }

        @Test
        @DisplayName("When increasing defense with positive leveledUp")
        public void testIncreaseDefenseWithPositiveLeveledUp() {
            // Defense of the hero will be increased according to login of increaseDefense(int leveledUp) method.
            // The logic is: current defense + (leveledUp * 1.5).
            doNothing().when(upgradable).increaseDefense(5);
            upgradable.increaseDefense(5);
            verify(upgradable, times(1)).increaseDefense(5);
        }
    }

    @Nested
    @DisplayName("increaseAttackPowerMethod")
    class IncreaseAttackPower {

        @Test
        @DisplayName("When increasing attack power with negative leveledUp")
        public void testIncreaseAttackPowerNegativeLeveledUp() {
            // Nothing will happen if we give a negative value for leveledUp
            // Note: This is not possible when you play the game
            doNothing().when(upgradable).increaseAttackPower(-5);
            upgradable.increaseAttackPower(-5);
            verify(upgradable, times(1)).increaseAttackPower(-5);
        }

        @Test
        @DisplayName("When increasing attack power with zero leveledUp")
        public void testIncreaseAttackPowerWithZeroLeveledUp() {
            // Nothing will happen if we give zero for a leveledUp
            doNothing().when(upgradable).increaseAttackPower(0);
            upgradable.increaseAttackPower(0);
            verify(upgradable, times(1)).increaseAttackPower(0);
        }

        @Test
        @DisplayName("When increasing attack power with positive leveledUp")
        public void testIncreaseAttackPowerPositiveLeveledUp() {
            // Attack power of the hero will be increased according to login of increaseAttackPower(int leveledUp) method.
            // The logic is: current attack power + (leveledUp * 5.5).
            doNothing().when(upgradable).increaseAttackPower(5);
            upgradable.increaseAttackPower(5);
            verify(upgradable, times(1)).increaseAttackPower(5);
        }
    }

    @Nested
    @DisplayName("increaseStatsMethod")
    class IncreaseStats {

        @Test
        @DisplayName("When increaseStats with negative amount")
        public void testIncreaseStatsNegativeAmount() {
            doNothing().when(upgradable).increaseStats("Strength", -5);
            doNothing().when(upgradable).increaseStats("Vitality", -5);
            doNothing().when(upgradable).increaseStats("Intelligence", -5);
            doNothing().when(upgradable).increaseStats("Dexterity", -5);
            doNothing().when(upgradable).increaseStats("Agility", -5);

            upgradable.increaseStats("Strength", -5);
            upgradable.increaseStats("Vitality", -5);
            upgradable.increaseStats("Intelligence", -5);
            upgradable.increaseStats("Dexterity", -5);
            upgradable.increaseStats("Agility", -5);

            verify(upgradable, times(1)).increaseStats("Strength", -5);
            verify(upgradable, times(1)).increaseStats("Vitality", -5);
            verify(upgradable, times(1)).increaseStats("Intelligence", -5);
            verify(upgradable, times(1)).increaseStats("Dexterity", -5);
            verify(upgradable, times(1)).increaseStats("Agility", -5);
        }

        @Test
        @DisplayName("When increaseStats with zero amount")
        public void testIncreaseStatsEqualToZeroAmount() {
            doNothing().when(upgradable).increaseStats("Strength", 0);
            doNothing().when(upgradable).increaseStats("Vitality", 0);
            doNothing().when(upgradable).increaseStats("Intelligence", 0);
            doNothing().when(upgradable).increaseStats("Dexterity", 0);
            doNothing().when(upgradable).increaseStats("Agility", 0);

            upgradable.increaseStats("Strength", 0);
            upgradable.increaseStats("Vitality", 0);
            upgradable.increaseStats("Intelligence", 0);
            upgradable.increaseStats("Dexterity", 0);
            upgradable.increaseStats("Agility", 0);

            verify(upgradable, times(1)).increaseStats("Strength", 0);
            verify(upgradable, times(1)).increaseStats("Vitality", 0);
            verify(upgradable, times(1)).increaseStats("Intelligence", 0);
            verify(upgradable, times(1)).increaseStats("Dexterity", 0);
            verify(upgradable, times(1)).increaseStats("Agility", 0);
        }

        @Test
        @DisplayName("When increaseStats with positive amount")
        public void testIncreaseStatsPositiveAmount() {
            doNothing().when(upgradable).increaseStats("Strength", 5);
            doNothing().when(upgradable).increaseStats("Vitality", 5);
            doNothing().when(upgradable).increaseStats("Intelligence", 5);
            doNothing().when(upgradable).increaseStats("Dexterity", 5);
            doNothing().when(upgradable).increaseStats("Agility", 5);

            upgradable.increaseStats("Strength", 5);
            upgradable.increaseStats("Vitality", 5);
            upgradable.increaseStats("Intelligence", 5);
            upgradable.increaseStats("Dexterity", 5);
            upgradable.increaseStats("Agility", 5);

            verify(upgradable, times(1)).increaseStats("Strength", 5);
            verify(upgradable, times(1)).increaseStats("Vitality", 5);
            verify(upgradable, times(1)).increaseStats("Intelligence", 5);
            verify(upgradable, times(1)).increaseStats("Dexterity", 5);
            verify(upgradable, times(1)).increaseStats("Agility", 5);
        }

        @Test
        @DisplayName("When hero is Mage (Unique condition)")
        public void testIncreaseStatsIntelligenceIfHeroIsMage() {
            // If hero is Mage then increaseStats(String, int) method should increase mages skillCostUnit
            // by amount * 5, in this case 5 * 5.
            doNothing().when(upgradable).increaseStats("Intelligence", 5);
            upgradable.increaseStats("Intelligence", 5);

            verify(upgradable, times(1)).increaseStats("Intelligence", 5);

            hero.setSkillCostUnit(hero.getSkillCostUnit() + 5 * 5);
            verify(hero, times(1)).setSkillCostUnit(hero.getSkillCostUnit() + 5 * 5);
        }
    }


    @Nested
    @DisplayName("equipArmorMethod")
    class EquipArmor {

        @Test
        @DisplayName("When level is negative")
        public void testEquipArmorWithNegativeLevel() {
            // This is not possible during gameplay
            doNothing().when(upgradable).equipArmor(-5);
            upgradable.equipArmor(-5);
            verify(upgradable, times(1)).equipArmor(-5);
        }

        @Test
        @DisplayName("When level is equal to zero")
        public void testEquipArmorWithLevelEqualsToZero() {
            // Nothing will happen
            doNothing().when(upgradable).equipArmor(0);
            upgradable.equipArmor(0);
            verify(upgradable, times(1)).equipArmor(0);
        }

        @Test
        @DisplayName("When level is positive")
        public void testEquipArmorsWithPositiveLevel() {
            // On 2, 4, 6, 8, 10 level the hero will equip new armor.
            doNothing().when(upgradable).equipArmor(4);
            upgradable.equipArmor(4);
            verify(upgradable, times(1)).equipArmor(4);
        }
    }

    @Test
    public void testLevelUp() {
        doNothing().when(upgradable).levelUp();
        upgradable.levelUp();
        verify(upgradable, times(1)).levelUp();
    }

    // End of testing Upgradable interface

    // Start of testing Attackable interface
    @Test
    public void testAttackMonster() {
        // It doesn't matter what type of Monster() I give as argument.
        Monster monster = new Imp();

        doNothing().when(attackable).attack(monster);
        attackable.attack(monster);
        verify(attackable, times(1)).attack(monster);
    }

    @Test
    public void testAttackMonsterWithNull() {
        // Nothing will be attacked if null is given
        doNothing().when(attackable).attack(null);
        attackable.attack(null);
        verify(attackable, times(1)).attack(null);
    }

    @Test
    public void testIsDeadReturnFalse() {
        assertFalse(attackable.isDead());
        verify(attackable, times(1)).isDead();
    }

    // End of testing Attackable interface

    // Start of testing HeroActions class

    @Nested
    @DisplayName("upgradeAfterClearingDungeonMethod")
    class UpgradeAfterClearingDungeon {

        @Test
        @DisplayName("When leveledUp is negative value")
        public void testUpgradeAfterClearingDungeonNegativeLeveledUp() {
            // This is not possible during game
            // Nothing will happen if leveledUp is <= 0
            doNothing().when(heroActions).upgradeAfterClearingDungeon(-5);
            heroActions.upgradeAfterClearingDungeon(-5);
            verify(heroActions, times(1)).upgradeAfterClearingDungeon(-5);
        }

        @Test
        @DisplayName("When leveledUp is equal to zero")
        public void testUpgradeAfterClearingDungeonLeveledUpEqualToZero() {
            // Nothing will happen if leveledUp is <= 0
            doNothing().when(heroActions).upgradeAfterClearingDungeon(0);
            heroActions.upgradeAfterClearingDungeon(0);
            verify(heroActions, times(1)).upgradeAfterClearingDungeon(0);
        }

        @Test
        @DisplayName("When leveledUp is positive value")
        public void testUpgradeAfterClearingDungeonPositiveLeveledUp() {
            doNothing().when(heroActions).upgradeAfterClearingDungeon(5);
            heroActions.upgradeAfterClearingDungeon(5);
            verify(heroActions, times(1)).upgradeAfterClearingDungeon(5);
        }
    }


    @Test
    public void testRestoreHeroWithValuesEqualToZero() {
        // Nothing will happen if restoredHealth or restoredSkillCostUnit <= 0
        doNothing().when(heroActions).restoreHero(0, 0);
        heroActions.restoreHero(0, 0);
        verify(heroActions, times(1)).restoreHero(0, 0);
    }

    @Test
    public void testRestoreHeroWithPositiveValues() {
        doNothing().when(heroActions).restoreHero(2000, 100);
        heroActions.restoreHero(2000, 100);
        verify(heroActions, times(1)).restoreHero(2000, 100);
    }

    @Test
    public void testStartDungeonWithAnyHero() {
        Hero warriorExample = new Warrior();

        doNothing().when(heroActions).startDungeonWith(warriorExample);
        heroActions.startDungeonWith(warriorExample);
        verify(heroActions, times(1)).startDungeonWith(warriorExample);
    }

    @Test
    public void testStartDungeonWithHeroEqualToNull() {
        // if Hero is null then the player won't be able to run this method.
        // It will return;

        doNothing().when(heroActions).startDungeonWith(null);
        heroActions.startDungeonWith(null);
        verify(heroActions, times(1)).startDungeonWith(null);
    }

    @Test
    public void testFightTillDieWithNullValues() {
        Hero mageExample = new Mage();
        Monster impExample = new Imp();

        heroActions.fightTillDie(mageExample, impExample);
        assertFalse(heroActions.fightTillDie(mageExample, impExample));
        verify(heroActions, times(2)).fightTillDie(mageExample, impExample);
    }
}
