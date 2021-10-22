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

    private Wizard persona;
//    private Warrior persona;
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
        this.enemy1 = new Enemy(random.nextInt((80 - 70) + 1) + 70, random.nextInt((15 - 10) + 1) + 10, random.nextInt((8 - 3) + 1) + 3);
        this.enemy2 = new Enemy(random.nextInt((90 - 85) + 1) + 85, random.nextInt((20 - 15) + 1) + 15, random.nextInt((10 - 5) + 1) + 5);
    }

    @BeforeEach
    @Description("If do you want to be a Warrior, comment the line 13 & 31 and uncomment the line 14, 32" +
                 "If do you want choose this equipments, uncomment the lines")
    public void startSceneryWithPerson() {
        this.persona = new Wizard(100, 10, 5, null);
//        this.persona = new Warrior(100, 8, 3, null);
        this.forest = new Forest(this.persona, enemy1, enemy2);
        this.desert = new Desert(this.persona, enemy1, enemy2);
        this.river = new River(this.persona, enemy1, enemy2);
        //Equipments
        this.archery = new Equipment(EquipmentsEnum.ARCHERY);
        this.armor = new Equipment(EquipmentsEnum.ARMOR);
        this.sword = new Equipment(EquipmentsEnum.SWORD);
        equipments.add(archery);
        equipments.add(armor);
        equipments.add(sword);
        persona.setInventory(equipments);
    }

    @Test
    @DisplayName("Should change equipment")
    public void shouldChangeEquipment() {
        persona.setInventory(equipments);
        Assertions.assertEquals(equipments.get(1).getName() ,persona.changeEquipment(1).getName());
    }

    @Test
    @DisplayName("Should change the current scenery to desert")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToDesert() {
        Assertions.assertAll(() -> assertEquals(new Desert(persona, enemy1, enemy2).getPersona(), river.changeToDesert().getPersona()),
                             () -> assertEquals(new Desert(persona, enemy1, enemy2).getPersona(), forest.changeToDesert().getPersona()));
    }

    @Test
    @DisplayName("Should change the current scenery to forest")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToForest() {
        Assertions.assertAll(() -> assertEquals(new Forest(persona, enemy1, enemy2).getPersona(), desert.changeToForest().getPersona()),
                             () -> assertEquals(new Forest(persona, enemy1, enemy2).getPersona(), river.changeToForest().getPersona()));
    }

    @Test
    @DisplayName("Should change the current scenery to river")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToRiver() {
        Assertions.assertAll(() -> assertEquals(new River(persona, enemy1, enemy2).getPersona(), forest.changeToRiver().getPersona()),
                             () -> assertEquals(new River(persona, enemy1, enemy2).getPersona(), desert.changeToRiver().getPersona()));
    }

    @Test
    @DisplayName("The persona should attack all enemies")
    @Description("As the enemy life is random, it's impossible know the really expected life")
    public void shouldAttackEnemy() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80 , persona.attack(enemy1)),
                             () -> assertEquals(80 , persona.attack(enemy2)));
    }

    @Test
    @DisplayName("The persona should defend the enemy attack")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldDefendTheEnemyAttack() {
        System.out.println("Enemy 1 attack: " + enemy1.getAttackPoint());
        System.out.println("Enemy 2 attack: " + enemy2.getAttackPoint());

        Assertions.assertAll(() -> assertEquals(80 , persona.defend(enemy1)),
                             () -> assertEquals(80 , persona.defend(enemy2)));
    }

    @Test
    @DisplayName("The persona should should attack all enemies using potion")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldAttackEnemyWithPotion() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80 , persona.usePotions(enemy1)),
                             () -> assertEquals(80 , persona.usePotions(enemy2)));
    }

    @Test
    @DisplayName("The enemy should attack persona")
    @Description("As the enemy attack point is random, it's impossible know the really expected damage")
    public void shouldAttackPersona() {
        System.out.println("Enemy 1 attack point: " + enemy1.getAttackPoint());
        System.out.println("Enemy 2 attack point: " + enemy2.getAttackPoint());

        Assertions.assertAll(() -> assertEquals(80 , enemy1.attack(this.persona)),
                             () -> assertEquals(90 , enemy2.attack(this.persona)));
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
