/**
 * Class responsible for instantiate
 * a Scenery
 *
 * @author Lucas Gomes
 */
public abstract class Scenery {

    private Persona persona;
    private Enemy enemy1;
    private Enemy enemy2;

    public Scenery(Persona persona, Enemy enemy1, Enemy enemy2) {
        this.persona = persona;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
    }

    public Persona getPersona() {
        return persona;
    }

    public Enemy getEnemy1() {
        return enemy1;
    }

    public Enemy getEnemy2() {
        return enemy2;
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
