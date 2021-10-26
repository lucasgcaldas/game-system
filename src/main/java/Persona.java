public abstract class Persona {

    private Integer lifePoint;
    private Integer attackPoint;
    private Integer defensePoint;

    /**
     * Persona Constructor
     *
     * @param lifePoint
     * @param attackPoint
     * @param defensePoint
     */
    public Persona(Integer lifePoint, Integer attackPoint, Integer defensePoint) {
        this.lifePoint = lifePoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }

    /**
     * Empty Constructor
     */
    public Persona() {
    }

    /**
     * Get getLifePoint
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
}
