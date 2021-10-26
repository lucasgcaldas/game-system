import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    private Wizard wizard;
    private Enemy enemy1, enemy2, dragon, goblin, zombie;

    @BeforeEach
    public void start() {
        Random random = new Random();
        this.wizard = new Wizard(null);
        this.dragon = new Enemy(EnemyEnum.DRAGON);
        this.goblin = new Enemy(EnemyEnum.GOBLIN);
        this.zombie = new Enemy(EnemyEnum.ZOMBIE);
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

    @Test
    public void shouldAttackNewEnemy() {
        System.out.println("Dragon life: " + dragon.getLifePoint());
        System.out.println("Goblin life: " + goblin.getLifePoint());
        System.out.println("Zombie life: " + zombie.getLifePoint());
        System.out.println("-----------------");
        System.out.println("Wizard improve : 10 + " + dragon.getMagicPoint() + " points on " + EnemyEnum.DRAGON);
        System.out.println("Wizard improve : 10 + " + goblin.getMagicPoint() + " points on " + EnemyEnum.GOBLIN);
        System.out.println("Wizard improve : 10 + " + zombie.getMagicPoint() + " points on " + EnemyEnum.ZOMBIE);

        Assertions.assertAll(() -> assertEquals(67, wizard.attackUsingMagic(dragon)),
                             () -> assertEquals(62, wizard.attackUsingMagic(goblin)),
                             () -> assertEquals(58, wizard.attackUsingMagic(zombie)));
    }
}