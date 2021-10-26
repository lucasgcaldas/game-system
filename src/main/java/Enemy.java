import java.util.Random;

/**
 * Class responsible for instantiate
 * an Enemy
 *
 * @author Lucas Gomes
 */
public class Enemy extends Persona {

    private Integer magicPoint;
    private Integer desertDamage;
    private Integer forestDamage;
    private Integer riverDamage;

    /**
     * Enemy Constructor of generic enemies
     *
     * @param random
     */
    public Enemy(Random random) {
        super(random.nextInt((80 - 70) + 1) + 70, random.nextInt((15 - 10) + 1) + 10, random.nextInt((8 - 3) + 1) + 3);
    }

    /**
     * Enemy Constructor of new kind of enemies
     *
     * @param enemyEnum
     */
    public Enemy(EnemyEnum enemyEnum) {
        super(enemyEnum.life(), enemyEnum.attack(), enemyEnum.defense());
        this.magicPoint = enemyEnum.magicPointDamage();
        this.desertDamage = enemyEnum.attackPointOnDesert();
        this.forestDamage = enemyEnum.attackPointOnForest();
        this.riverDamage = enemyEnum.attackPointOnRiver();
    }

    /**
     * Empty Constructor
     */
    public Enemy() {
        super();
    }

    /**
     * Get upgradeDamage
     *
     * @return Integer
     */
    public Integer getMagicPoint() {
        return magicPoint;
    }

    /**
     * Get desertDamage
     *
     * @return Integer
     */
    public Integer getDesertDamage() {
        return desertDamage;
    }

    /**
     * Get forestDamage
     *
     * @return Integer
     */
    public Integer getForestDamage() {
        return forestDamage;
    }

    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @return Integer
     */
    public Integer attackHero(Hero hero) {
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
