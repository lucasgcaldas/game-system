package entities;

public class Desert extends Scenery{

    public Desert(Persona persona, Enemy enemy) {
        super(persona, enemy);
    }

    @Override
    public Scenery changeToForest() {
        return new Forest(this.getPersona(), new Enemy());
    }

    @Override
    public Scenery changeToRiver() {
        return new River(this.getPersona(), new Enemy());
    }
}
