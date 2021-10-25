/**
 * Class that extends Scenery and
 * is responsible for instantiate
 * a Forest
 *
 * @author Lucas Gomes
 */
public class Forest extends Scenery {

    public Forest(Persona persona, Enemy enemy1, Enemy enemy2) {
        super(persona, enemy1, enemy2);
    }

    /**
     * Method responsible for change
     * the current scenery to Desert
     *
     * @return Integer
     */
    public Scenery changeToDesert() {
        return new Desert(this.getPersona(), new Enemy(), new Enemy());
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
