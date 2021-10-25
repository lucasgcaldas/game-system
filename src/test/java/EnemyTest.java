import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    private Wizard persona;
    //    private Warrior persona;
    private Enemy enemy1, enemy2;
    Random random = new Random();

    @BeforeEach
    @Description("If do you want to be a Warrior, comment the line 13 & 23 and uncomment the line 14, 24" +
            "If do you want choose this equipments, uncomment the lines")
    public void start() {
        this.persona = new Wizard(100, 10, 5, null);
//        this.persona = new Warrior(100, 8, 3, null);
        this.enemy1 = new Enemy(random.nextInt((80 - 70) + 1) + 70, random.nextInt((15 - 10) + 1) + 10, random.nextInt((8 - 3) + 1) + 3);
        this.enemy2 = new Enemy(random.nextInt((90 - 85) + 1) + 85, random.nextInt((20 - 15) + 1) + 15, random.nextInt((10 - 5) + 1) + 5);
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