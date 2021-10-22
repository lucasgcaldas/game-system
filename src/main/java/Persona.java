import java.util.List;

/**
 * Abstract class that only
 * idealizes one type of character
 *
 * @author Lucas Gomes
 */
public abstract class Persona implements PersonaSkills {

    private Integer lifePoint;
    private Integer attackPoint;
    private Integer defensePoint;
    private List<Equipment> inventory;

    public Persona(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<Equipment> inventory) {
        this.lifePoint = lifePoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.inventory = inventory;
    }

    public Integer getLifePoint() {
        return lifePoint;
    }

    public Integer getAttackPoint() {
        return attackPoint;
    }

    public Integer getDefensePoint() {
        return defensePoint;
    }

    public List<Equipment> getInventory() {
        return inventory;
    }

    public void setInventory(List<Equipment> equipment) {
        this.inventory = equipment;
    }

    /**
     * method responsible for
     * change the current equipment
     * to other
     *
     * @param i
     * @return Equipment
     */
    public Equipment changeEquipment(int i) {
        return this.inventory.get(i);
    }
}
