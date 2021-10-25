import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private Warrior warrior;
    private Enemy enemy1, enemy2;
    Random random = new Random();

    @BeforeEach
    public void start() {
        this.warrior = new Warrior(100, 8, 3, null);
        this.enemy1 = new Enemy(random.nextInt((80 - 70) + 1) + 70, random.nextInt((15 - 10) + 1) + 10, random.nextInt((8 - 3) + 1) + 3);
        this.enemy2 = new Enemy(random.nextInt((90 - 85) + 1) + 85, random.nextInt((20 - 15) + 1) + 15, random.nextInt((10 - 5) + 1) + 5);
    }

    @Test
    @DisplayName("The persona should attack all enemies")
    @Description("As the enemy life is random, it's impossible know the really expected life")
    public void shouldAttackEnemy() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80 , warrior.attack(enemy1)),
                             () -> assertEquals(80 , warrior.attack(enemy2)));
    }

    @Test
    @DisplayName("The persona should defend the enemy attack")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldDefendTheEnemyAttack() {
        System.out.println("Enemy 1 attack: " + enemy1.getAttackPoint());
        System.out.println("Enemy 2 attack: " + enemy2.getAttackPoint());

        Assertions.assertAll(() -> assertEquals(80 , warrior.defend(enemy1)),
                             () -> assertEquals(80 , warrior.defend(enemy2)));
    }

    @Test
    @DisplayName("The persona should should attack all enemies using potion")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldAttackEnemyWithPotion() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80 , warrior.usePotions(enemy1)),
                             () -> assertEquals(80 , warrior.usePotions(enemy2)));
    }
}