package entities;

/**
 * Class responsible for instantiate
 * a Scenery
 * @author Lucas Gomes
 */
public class Scenery {

    private Persona persona;
    private SceneryEnum[] scenarios;
    private Enemy[] enemies;

    public Scenery(Persona persona, SceneryEnum[] scenarios, Enemy[] enemies) {
        this.persona = persona;
        this.scenarios = scenarios;
        this.enemies = enemies;
    }

    public Persona getPersona() {
        return persona;
    }

    public SceneryEnum[] getScenarios() {
        return scenarios;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    /**
     * method responsible for change
     * the scenery
     */
    public SceneryEnum changeScenery(int number) {
        if(number == 1){
            return SceneryEnum.DESERT;
        }if(number == 2){
            return SceneryEnum.FOREST;
        }else{
            return SceneryEnum.RIVER;
        }
    }
}
