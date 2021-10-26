import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RiverTest {

    private Wizard hero;
    //    private Warrior hero;
    private River river;
    private River riverDragon, riverGoblin, riverZombie;
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
        this.river = new River(this.hero, enemy1, enemy2);
        this.riverDragon = new River(hero, dragon);
        this.riverGoblin = new River(hero, goblin);
        this.riverZombie = new River(hero, zombie);
        this.dragon = new Enemy(EnemyEnum.DRAGON);
        this.goblin = new Enemy(EnemyEnum.GOBLIN);
        this.zombie = new Enemy(EnemyEnum.ZOMBIE);
    }

    @Test
    @DisplayName("Should change the current scenery to desert")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToDesert() {
        assertEquals(new Forest(hero, enemy1, enemy2).getHero(), river.changeToDesert().getHero());
    }

    @Test
    @DisplayName("Should change the current scenery to forest")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToForest() {
        assertEquals(new River(hero, enemy1, enemy2).getHero(), river.changeToForest().getHero());
    }

    @Test
    @DisplayName("Should not duplicate damage on dragon")
    public void shouldNotDuplicateDamageOnDragon(){
        Assertions.assertAll(() -> assertEquals(67, riverDragon.attackOnScenery(dragon, hero)),
                () -> assertEquals(62, riverGoblin.attackOnScenery(goblin, hero)),
                () -> assertEquals(58, riverZombie.attackOnScenery(zombie, hero)));
    }
}