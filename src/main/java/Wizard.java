import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Wizard
 *
 * @author Lucas Gomes
 */
public class Wizard extends Hero{

    /**
     * Wizard Constructor
     *
     * @param inventory
     */
    public Wizard(List<Equipment> inventory) {
        super(100, 10, 5, inventory);
    }

    public Integer attackUsingMagic(Enemy enemy){
        return enemy.getLifePoint() - (this.getAttackPoint() + enemy.getMagicPoint());
    }
}
