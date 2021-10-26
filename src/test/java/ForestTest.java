import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ForestTest {

    private Wizard hero;
    //    private Warrior hero;
    private Forest forest;
    private Forest forestDragon, forestGoblin, forestZombie;
    private Enemy enemy1, enemy2, dragon, goblin, zombie;

    @BeforeEach
    @Description("If do you want to be a Warrior, comment the line 12 & 22 and uncomment the line 13, 23" +
            "If do you want choose this equipments, uncomment the lines")
    public void start() {
        Random random = new Random();
        this.hero = new Wizard(null);
//        this.hero = new Warrior(null);
        this.enemy1 = new Enemy(random);
        this.enemy2 = new Enemy(random);
        this.forest = new Forest(hero, enemy1, enemy2);
        this.dragon = new Enemy(EnemyEnum.DRAGON);
        this.goblin = new Enemy(EnemyEnum.GOBLIN);
        this.zombie = new Enemy(EnemyEnum.ZOMBIE);
        this.forestDragon = new Forest(hero, dragon);
        this.forestGoblin = new Forest(hero, goblin);
        this.forestZombie = new Forest(hero, zombie);
    }

    @Test
    @DisplayName("Should change the current scenery to desert")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToDesert() {
        assertEquals(new Forest(hero, enemy1, enemy2).getHero(), forest.changeToDesert().getHero());
    }

    @Test
    @DisplayName("Should change the current scenery to river")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToRiver() {
        assertEquals(new River(hero, enemy1, enemy2).getHero(), forest.changeToRiver().getHero());
    }

    @Test
    @DisplayName("Should duplicate damage on dragon")
    public void shouldDuplicateDamageOnDragon(){
        Assertions.assertAll(() -> assertEquals(47, forestDragon.attackOnScenery(dragon, hero)),
                             () -> assertEquals(62, forestGoblin.attackOnScenery(goblin, hero)),
                             () -> assertEquals(58, forestZombie.attackOnScenery(zombie, hero)));
    }
}