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

    @Override
    public Scenery changeToForest() {
        return new Forest(this.getPersona(), new Enemy(), new Enemy());
    }

    @Override
    public Scenery changeToRiver() {
        return new River(this.getPersona(), new Enemy(), new Enemy());
    }
}
