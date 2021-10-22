public interface PersonaSkills {

    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @param enemy
     * @return Integer
     */
    Integer attack(Enemy enemy);

    /**
     * method responsible for calculate
     * the persona life after an attack
     *
     * @return Integer
     */
    Integer defend(Enemy enemy);

    /**
     * method responsible for calculate
     * the persona life after an attack
     *
     * @param enemy
     * @return Integer
     */
    Integer usePotions(Enemy enemy);
}
