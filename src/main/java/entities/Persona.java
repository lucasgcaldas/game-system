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
//
//    public void attack(Enemy[] enemies, Persona persona) {
//    }
//
//    public void defend(Enemy[] enemies, Persona persona) {
//    }
//
//    public void usePotions(Enemy[] enemies, Persona persona) {
//    }

    public void changeEquipments() {

    }
}
