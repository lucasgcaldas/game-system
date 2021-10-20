package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that only
 * idealizes one type of character
 * @author Lucas Gomes
 */
public abstract class Persona {

    private Integer lifePoint;
    private Integer attackPoint;
    private Integer defensePoint;
    private List<EquipmentsEnum> inventory;

    public Persona(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<EquipmentsEnum> inventory) {
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

    public List<EquipmentsEnum> getInventory() {
        return inventory;
    }

    /**
     * method responsible for calculate
     * the persona life after an attack
     */
    public int attack(int enemyLife, Persona persona) {
        return 0;
    }

    /**
     * method responsible for calculate
     * the persona life after an attack
     */
    public int defend(int wizardHp, Persona persona) {
        return 0;
    }

    /**
     * method responsible for calculate
     * the persona life after an attack
     */
    public int usePotions(int enemyLife, Persona persona) {
        return 0;
    }
}
