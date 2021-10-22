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

    @Override
    public Scenery changeToDesert() {
        return new Desert(this.getPersona(), new Enemy(), new Enemy());
    }

    @Override
    public Scenery changeToRiver() {
        return new River(this.getPersona(), new Enemy(), new Enemy());
    }
}
