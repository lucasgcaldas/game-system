import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Warrior
 *
 * @author Lucas Gomes
 */
public class Warrior extends Persona {

    /**
     * Warrior Constructor
     *
     * @param lifePoint
     * @param attackPoint
     * @param defensePoint
     * @param inventory
     */
    public Warrior(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<Equipment> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }

    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @param enemy
     * @return Integer
     */
    @Override
    public Integer usePotions(Enemy enemy) {
        return (int) (enemy.getLifePoint() - this.getAttackPoint() * 1.10);
    }
}
