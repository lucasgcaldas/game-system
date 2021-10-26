/**
 * Class that extends Scenery and
 * is responsible for instantiate
 * a Forest
 *
 * @author Lucas Gomes
 */
public class Forest extends Scenery {

    /**
     * Forest Constructor
     *
     * @param hero
     * @param enemy1
     * @param enemy2
     */
    public Forest(Hero hero, Enemy enemy1, Enemy enemy2) {
        super(hero, enemy1, enemy2);
    }

    /**
     * Method responsible for change
     * the current scenery to Desert
     *
     * @return Scenery
     */
    public Scenery changeToDesert() {
        return new Desert(this.getHero(), new Enemy(), new Enemy());
    }

    /**
     * Method responsible for change
     * the current scenery to River
     *
     * @return Scenery
     */
    public Scenery changeToRiver() {
        return new River(this.getHero(), new Enemy(), new Enemy());
    }
}
