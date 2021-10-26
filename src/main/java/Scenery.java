/**
 * Class responsible for instantiate
 * a Scenery
 *
 * @author Lucas Gomes
 */
public abstract class Scenery {

    private Hero hero;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy;

    /**
     * Scenery Constructor
     *
     * @param hero
     * @param enemy1
     * @param enemy2
     */
    public Scenery(Hero hero, Enemy enemy1, Enemy enemy2) {
        this.hero = hero;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
    }

    public Scenery(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    /**
     * Get persona
     *
     * @return Persona
     */
    public Hero getHero() {
        return hero;
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

    public Enemy getEnemy() {
        return enemy;
    }

    public Integer getDragonPoint(){
        return EnemyEnum.DRAGON.attack();
    }
}
