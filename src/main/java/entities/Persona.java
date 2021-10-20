package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {

    private Integer lifePoint;
    private Integer attackPoint;
    private Integer defensePoint;
    private List<EquipmentsEnum> inventory = new ArrayList<>();

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


    public int attack(int enemyLife, Persona persona) {
        return 0;
    }

    public int defend(int wizardHp, Persona persona) {
        return 0;
    }

    public int usePotions(int enemyLife, Persona persona) {
        return 0;
    }

    public void changeEquipments() {

    }
}
