package entities;

public class Forest extends Scenery{

    public Forest(Persona persona, Enemy enemy) {
        super(persona, enemy);
    }

    @Override
    public Scenery changeToDesert() {
        return new Desert(this.getPersona(), new Enemy());
    }

    @Override
    public Scenery changeToRiver() {
        return new River(this.getPersona(), new Enemy());
    }
}
