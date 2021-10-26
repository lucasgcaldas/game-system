import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DesertTest {

    private Wizard hero;
    //    private Warrior hero;
    private Desert desert;
    private Desert desertDragon, desertGoblin, desertZombie;
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
        this.desert = new Desert(this.hero, enemy1, enemy2);
        this.desertDragon = new Desert(hero, dragon);
        this.desertGoblin = new Desert(hero, goblin);
        this.desertZombie = new Desert(hero, zombie);
        this.dragon = new Enemy(EnemyEnum.DRAGON);
        this.goblin = new Enemy(EnemyEnum.GOBLIN);
        this.zombie = new Enemy(EnemyEnum.ZOMBIE);
    }

    @Test
    @DisplayName("Should change the current scenery to forest")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToForest() {
        assertEquals(new Forest(hero, enemy1, enemy2).getHero(), desert.changeToForest().getHero());
    }

    @Test
    @DisplayName("Should change the current scenery to river")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToRiver() {
        assertEquals(new River(hero, enemy1, enemy2).getHero(), desert.changeToRiver().getHero());
    }

    @Test
    @DisplayName("Should not duplicate damage on dragon")
    public void shouldNotDuplicateDamageOnDragon(){
        Assertions.assertAll(() -> assertEquals(67, desertDragon.attackOnScenery(dragon, hero)),
                () -> assertEquals(62, desertGoblin.attackOnScenery(goblin, hero)),
                () -> assertEquals(58, desertZombie.attackOnScenery(zombie, hero)));
    }
}