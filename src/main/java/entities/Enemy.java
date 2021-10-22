package entities;

/**
 * Class responsible for instantiate
 * an Enemy
 * @author Lucas Gomes
 */
public class Enemy {

    private Integer lifePoint;
    private Integer attackPoint;
    private Integer defensePoint;

    public Enemy(Integer lifePoint, Integer attackPoint, Integer defensePoint) {
        this.lifePoint = lifePoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }

    public Enemy() {
    }

    public Integer getLifePoint() {
        return lifePoint;
    }

    public Integer getAttackPoint() {
        return attackPoint;
    }

    public Integer getDefensePoint() {
        return defensePoint;
    }

    /**
     * Method responsible for calculate
     * the persona life after an attack
     * @return Integer
     */
    public Integer attack(Persona persona) {
        return persona.getLifePoint() - this.getAttackPoint();
    }

    /**
     * Method responsible for calculate
     * the enemy life after a defense
     * @return Integer
     */
    public Integer defend() {
        return this.getLifePoint() + this.getDefensePoint();
    }
}
