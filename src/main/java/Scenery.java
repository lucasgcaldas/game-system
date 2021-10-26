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

    /**
     * Scenery Constructor
     *
     * @param persona
     * @param enemy1
     * @param enemy2
     */
    public Scenery(Persona persona, Enemy enemy1, Enemy enemy2) {
        this.persona = persona;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
    }

    /**
     * Get persona
     *
     * @return Persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Get enemy1
     *
     * @return
     */
    public Enemy getEnemy1() {
        return enemy1;
    }

    /**
     * Get enemy2
     *
     * @return
     */
    public Enemy getEnemy2() {
        return enemy2;
    }
}
