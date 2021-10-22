package entities;

public class River extends Scenery{

    public River(Persona persona, Enemy enemy) {
        super(persona, enemy);
    }

    @Override
    public Scenery changeToDesert() {
        return new Desert(this.getPersona(), new Enemy());
    }

    @Override
    public Scenery changeToForest() {
        return new Forest(this.getPersona(), new Enemy());
    }
}
