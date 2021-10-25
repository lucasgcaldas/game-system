import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ForestTest {

    private Wizard persona;
    //    private Warrior persona;
    private Forest forest;
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
        this.forest = new Forest(this.persona, enemy1, enemy2);
    }

    @Test
    @DisplayName("Should change the current scenery to desert")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToDesert() {
        assertEquals(new Forest(persona, enemy1, enemy2).getPersona(), forest.changeToDesert().getPersona());
    }

    @Test
    @DisplayName("Should change the current scenery to river")
    @Description("Check if it's the same from the persona's name, because it builds a new scenery")
    public void shouldChangeToRiver() {
        assertEquals(new River(persona, enemy1, enemy2).getPersona(), forest.changeToRiver().getPersona());
    }
}