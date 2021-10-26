/**
 * Class responsible for instantiate
 * an Enemy
 *
 * @author Lucas Gomes
 */
public class Enemy {

    private Integer lifePoint;
    private Integer attackPoint;
    private Integer defensePoint;

    /**
     * Enemy Constructor
     *
     * @param lifePoint
     * @param attackPoint
     * @param defensePoint
     */
    public Enemy(Integer lifePoint, Integer attackPoint, Integer defensePoint) {
        this.lifePoint = lifePoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }

    /**
     * Empty Constructor
     */
    public Enemy() {
    }

    /**
     * Get lifePoint
     *
     * @return Integer
     */
    public Integer getLifePoint() {
        return lifePoint;
    }

    /**
     * Get attackPoint
     *
     * @return Integer
     */
    public Integer getAttackPoint() {
        return attackPoint;
    }

    /**
     * Get defensePoint
     *
     * @return Integer
     */
    public Integer getDefensePoint() {
        return defensePoint;
    }

    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @return Integer
     */
    public Integer attack(Persona persona) {
        return persona.getLifePoint() - this.getAttackPoint();
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
