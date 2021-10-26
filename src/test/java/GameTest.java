import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Wizard hero;
//    private Warrior hero;
    private Enemy enemy1;
    private Enemy enemy2;
    private Forest forest;
    private Desert desert;
    private River river;
    private Equipment archery;
    private Equipment armor;
    private Equipment sword;
    private List<Equipment> equipments = new ArrayList<>();

    @BeforeEach
    public void startEnemy() {
        Random random = new Random();
        this.enemy1 = new Enemy(random);
        this.enemy2 = new Enemy(random);
    }

    @BeforeEach
    @Description("If do you want to be a Warrior, comment the line 13 & 31 and uncomment the line 14, 32" +
                 "If do you want choose this equipments, uncomment the lines")
    public void startSceneryWithPerson() {
        this.hero = new Wizard(null);
//        this.hero = new Warrior(null);
        this.forest = new Forest(this.hero, enemy1, enemy2);
        this.desert = new Desert(this.hero, enemy1, enemy2);
        this.river = new River(this.hero, enemy1, enemy2);
        //Equipments
        this.archery = new Equipment(EquipmentsEnum.ARCHERY);
        this.armor = new Equipment(EquipmentsEnum.ARMOR);
        this.sword = new Equipment(EquipmentsEnum.SWORD);
        equipments.add(archery);
        equipments.add(armor);
        equipments.add(sword);
        hero.setInventory(equipments);
    }

    @Test
    @DisplayName("Should change equipment")
    public void shouldChangeEquipment() {
        hero.setInventory(equipments);
        Assertions.assertEquals(equipments.get(1).getName() , hero.changeEquipment(1).getName());
    }

    @Test
    @DisplayName("Should change the current scenery to desert")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToDesert() {
        Assertions.assertAll(() -> assertEquals(new Desert(hero, enemy1, enemy2).getHero(), river.changeToDesert().getHero()),
                             () -> assertEquals(new Desert(hero, enemy1, enemy2).getHero(), forest.changeToDesert().getHero()));
    }

    @Test
    @DisplayName("Should change the current scenery to forest")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToForest() {
        Assertions.assertAll(() -> assertEquals(new Forest(hero, enemy1, enemy2).getHero(), desert.changeToForest().getHero()),
                             () -> assertEquals(new Forest(hero, enemy1, enemy2).getHero(), river.changeToForest().getHero()));
    }

    @Test
    @DisplayName("Should change the current scenery to river")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToRiver() {
        Assertions.assertAll(() -> assertEquals(new River(hero, enemy1, enemy2).getHero(), forest.changeToRiver().getHero()),
                             () -> assertEquals(new River(hero, enemy1, enemy2).getHero(), desert.changeToRiver().getHero()));
    }

    @Test
    @DisplayName("The persona should attack all enemies")
    @Description("As the enemy life is random, it's impossible know the really expected life")
    public void shouldAttackEnemy() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80 , hero.attackEnemy(enemy1)),
                             () -> assertEquals(80 , hero.attackEnemy(enemy2)));
    }

    @Test
    @DisplayName("The persona should defend the enemy attack")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldDefendTheEnemyAttack() {
        System.out.println("Enemy 1 attack: " + enemy1.getAttackPoint());
        System.out.println("Enemy 2 attack: " + enemy2.getAttackPoint());

        Assertions.assertAll(() -> assertEquals(80 , hero.defendFromEnemy(enemy1)),
                             () -> assertEquals(80 , hero.defendFromEnemy(enemy2)));
    }

    @Test
    @DisplayName("The persona should should attack all enemies using potion")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldAttackEnemyWithPotion() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80 , hero.usePotions(enemy1)),
                             () -> assertEquals(80 , hero.usePotions(enemy2)));
    }

    @Test
    @DisplayName("The enemy should attack persona")
    @Description("As the enemy attack point is random, it's impossible know the really expected damage")
    public void shouldAttackPersona() {
        System.out.println("Enemy 1 attack point: " + enemy1.getAttackPoint());
        System.out.println("Enemy 2 attack point: " + enemy2.getAttackPoint());

        Assertions.assertAll(() -> assertEquals(80 , enemy1.attack(this.hero)),
                             () -> assertEquals(90 , enemy2.attack(this.hero)));
    }

    @Test
    @DisplayName("The persona should defend the enemy attack")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldDefendTheEPersonaAttack() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80 , enemy1.defend()),
                             () -> assertEquals(80 , enemy2.defend()));
    }
}
