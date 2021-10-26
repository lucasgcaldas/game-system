import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    private Wizard hero;
    //    private Warrior hero;
    private Enemy enemy1, enemy2;

    @BeforeEach
    @Description("If do you want to be a Warrior, comment the line 13 & 22 and uncomment the line 14, 23" +
            "If do you want choose this equipments, uncomment the lines")
    public void start() {
        Random random = new Random();
        this.hero = new Wizard(null);
//        this.hero = new Warrior(null);
        this.enemy1 = new Enemy(random);
        this.enemy2 = new Enemy(random);
    }

    @Test
    @DisplayName("The enemy should attack persona")
    @Description("As the enemy attack point is random, it's impossible know the really expected damage")
    public void shouldAttackPersona() {
        System.out.println("Enemy 1 attack point: " + enemy1.getAttackPoint());
        System.out.println("Enemy 2 attack point: " + enemy2.getAttackPoint());

        Assertions.assertAll(() -> assertEquals(80, enemy1.attack(this.hero)),
                () -> assertEquals(90, enemy2.attack(this.hero)));
    }

    @Test
    @DisplayName("The persona should defend the enemy attack")
    @Description("As the enemy attack is random, it's impossible know the really expected life")
    public void shouldDefendTheEPersonaAttack() {
        System.out.println("Enemy 1 life: " + enemy1.getLifePoint());
        System.out.println("Enemy 2 life: " + enemy2.getLifePoint());

        Assertions.assertAll(() -> assertEquals(80, enemy1.defend()),
                () -> assertEquals(80, enemy2.defend()));
    }
}