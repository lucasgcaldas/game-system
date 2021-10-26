/**
 * Class that extends Scenery and
 * is responsible for instantiate
 * a River
 *
 * @author Lucas Gomes
 */
public class River extends Scenery implements BattleOnScenery {

    /**
     * River Constructor
     *
     * @param hero
     * @param enemy1
     * @param enemy2
     */
    public River(Hero hero, Enemy enemy1, Enemy enemy2) {
        super(hero, enemy1, enemy2);
    }

    /**
     * River Constructor
     *
     * @param hero
     * @param enemy
     */
    public River(Hero hero, Enemy enemy) {
        super(hero, enemy);
    }

    /**
     * Method responsible for change
     * the current scenery to Desert
     *
     * @return Integer
     */
    public Scenery changeToDesert() {
        return new Desert(this.getHero(), new Enemy(), new Enemy());
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

    @Override
    public Integer attackOnScenery(Enemy enemy, Hero hero) {
        return enemy.getLifePoint() - (hero.getAttackPoint() + enemy.getMagicPoint() + enemy.getDesertDamage());
    }
}
