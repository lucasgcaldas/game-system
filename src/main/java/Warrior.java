import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Warrior
 *
 * @author Lucas Gomes
 */
public class Warrior extends Hero {

    /**
     * Warrior Constructor
     *
     * @param inventory
     */
    public Warrior(List<Equipment> inventory) {
        super(100, 8, 3, inventory);
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
