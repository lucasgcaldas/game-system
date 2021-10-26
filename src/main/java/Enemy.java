import java.util.Random;

/**
 * Class responsible for instantiate
 * an Enemy
 *
 * @author Lucas Gomes
 */
public class Enemy extends Persona{

    /**
     * Enemy Constructor
     *
     * @param random
     */
    public Enemy(Random random) {
        super(random.nextInt((80 - 70) + 1) + 75, random.nextInt((15 - 10) + 1) + 13, random.nextInt((8 - 3) + 1) +5);
    }

    /**
     * Empty Constructor
     */
    public Enemy() {
        super();
    }


    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @return Integer
     */
    public Integer attack(Hero hero) {
        return hero.getLifePoint() - this.getAttackPoint();
    }

    /**
     * Method responsible for calculate
     * the enemy life after a defense
     *
     * @return Integer
     */
    public Integer defend() {
        return this.getLifePoint() + this.getDefensePoint();
    }
}
