/**
 * Class that extends Scenery and
 * is responsible for instantiate
 * a Desert
 *
 * @author Lucas Gomes
 */
public class Desert extends Scenery {

    /**
     * Desert Constructor
     * @param hero
     * @param enemy1
     * @param enemy2
     */
    public Desert(Hero hero, Enemy enemy1, Enemy enemy2) {
        super(hero, enemy1, enemy2);
    }

    /**
     * Method responsible for change
     * the current scenery to Forest
     *
     * @return Integer
     */
    public Scenery changeToForest() {
        return new Forest(this.getHero(), new Enemy(), new Enemy());
    }

    /**
     * Method responsible for change
     * the current scenery to River
     *
     * @return Integer
     */
    public Scenery changeToRiver() {
        return new River(this.getHero(), new Enemy(), new Enemy());
    }
}
