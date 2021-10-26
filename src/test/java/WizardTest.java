import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    private Wizard wizard;
    private Enemy enemy1, enemy2;

    @BeforeEach
    public void start() {
        Random random = new Random();
        this.wizard = new Wizard(null);
        this.enemy1 = new Enemy(random);
        this.enemy2 = new Enemy(random);
    }

    @Test
    @DisplayName("The persona should attack all enemies")
    @Description("As the enemy life is random, it's impossible know the really expected life")
    public void shouldAttackEnemy() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80, wizard.attackEnemy(enemy1)),
                () -> assertEquals(80, wizard.attackEnemy(enemy2)));
    }

    @Test
    @DisplayName("The persona should defend the enemy attack")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldDefendTheEnemyAttack() {
        System.out.println("Enemy 1 attack: " + enemy1.getAttackPoint());
        System.out.println("Enemy 2 attack: " + enemy2.getAttackPoint());

        Assertions.assertAll(() -> assertEquals(80, wizard.defendFromEnemy(enemy1)),
                () -> assertEquals(80, wizard.defendFromEnemy(enemy2)));
    }

    @Test
    @DisplayName("The persona should should attack all enemies using potion")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldAttackEnemyWithPotion() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80, wizard.usePotions(enemy1)),
                () -> assertEquals(80, wizard.usePotions(enemy2)));
    }
}