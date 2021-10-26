import java.util.List;

/**
 * Abstract class that only
 * idealizes one type of character
 *
 * @author Lucas Gomes
 */
public abstract class Hero extends Persona{

    private List<Equipment> inventory;

    /**
     * Persona Constructor
     *
     * @param lifePoint
     * @param attackPoint
     * @param defensePoint
     * @param inventory
     */
    public Hero(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<Equipment> inventory) {
        super(lifePoint, attackPoint, defensePoint);
        this.inventory = inventory;
    }

    /**
     * Get inventory
     *
     * @return List<Equipment>
     */
    public List<Equipment> getInventory() {
        return inventory;
    }

    /**
     * Set equipment
     *
     * @param equipment
     */
    public void setInventory(List<Equipment> equipment) {
        this.inventory = equipment;
    }

    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @param enemy
     * @return Integer
     */
    public Integer attackEnemy(Enemy enemy) {
        int upgradeAttack = 0;
        if (getInventory() != null) {
            for (int i = 0; i < this.getInventory().size(); i++) {
                upgradeAttack += this.getInventory().get(i).getImproveDamage();
            }
        }
        return enemy.getLifePoint() - this.getAttackPoint() - upgradeAttack;
    }

    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @param enemy
     * @return Integer
     */
    public Integer defendFromEnemy(Enemy enemy) {
        int upgradeDefend = 0;
        if (getInventory() != null) {
            for (int i = 0; i < this.getInventory().size(); i++) {
                upgradeDefend += this.getInventory().get(i).getReduceDamage();
            }
        }
        return this.getLifePoint() + this.getDefensePoint() - enemy.getAttackPoint() + upgradeDefend;
    }

    /**
     * Method responsible for calculate
     * the persona life after an attack
     *
     * @param enemy
     * @return Integer
     */
    public Integer usePotions(Enemy enemy) {
        return (int) (enemy.getLifePoint() - this.getAttackPoint() * 1.15);
    }

    /**
     * Method responsible for
     * change the current equipment
     * to other
     *
     * @param i
     * @return Equipment
     */
    public Equipment changeEquipment(int i) {
        return this.inventory.get(i);
    }

    public Integer attackOnScenery(Enemy enemy, Scenery scenery){
        return enemy.getLifePoint() - scenery.getDragonPoint() - this.getAttackPoint();
    }
}
