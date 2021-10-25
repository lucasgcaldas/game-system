/**
 * Class that extends Scenery and
 * is responsible for instantiate
 * a River
 *
 * @author Lucas Gomes
 */
public class River extends Scenery {

    public River(Persona persona, Enemy enemy1, Enemy enemy2) {
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
     * the current scenery to Forest
     *
     * @return Integer
     */
    public Scenery changeToForest() {
        return new Forest(this.getPersona(), new Enemy(), new Enemy());
    }
}
