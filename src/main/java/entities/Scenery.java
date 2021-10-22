package entities;

import java.util.List;

/**
 * Class responsible for instantiate
 * a Scenery
 * @author Lucas Gomes
 */
public abstract class Scenery {

    private Persona persona;
    private Enemy enemy;

    public Scenery(Persona persona, Enemy enemy) {
        this.persona = persona;
        this.enemy = enemy;
    }

    public Persona getPersona() {
        return persona;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Scenery changeToDesert() {
        return new Desert(this.getPersona(), new Enemy());
    }

    public Scenery changeToRiver() {
        return new River(this.getPersona(), new Enemy());
    }

    public Scenery changeToForest() {
        return new Forest(this.getPersona(), new Enemy());
    }
}
