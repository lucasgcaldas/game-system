import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Wizard
 *
 * @author Lucas Gomes
 */
public class Wizard extends Persona {

    public Wizard(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<Equipment> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }
}
