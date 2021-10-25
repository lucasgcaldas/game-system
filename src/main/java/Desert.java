/**
 * Class that extends Scenery and
 * is responsible for instantiate
 * a Desert
 *
 * @author Lucas Gomes
 */
public class Desert extends Scenery {

    public Desert(Persona persona, Enemy enemy1, Enemy enemy2) {
        super(persona, enemy1, enemy2);
    }

    /**
     * Method responsible for change
     * the current scenery to Forest
     *
     * @return Integer
     */
    public Scenery changeToForest() {
        return new Forest(this.getPersona(), new Enemy(), new Enemy());
    }

    /**
     * Method responsible for change
     * the current scenery to River
     *
     * @return Integer
     */
    public Scenery changeToRiver() {
        return new River(this.getPersona(), new Enemy(), new Enemy());
    }
}
