import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DesertTest {

    private Wizard hero;
    //    private Warrior hero;
    private Desert desert;
    private Enemy enemy1, enemy2;

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
}