package entities;

import java.util.List;

public class Warrior extends Persona{

    public Warrior(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<EquipmentsEnum> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }


    public int attack(Enemy enemy, Warrior warrior) {
        return 1;
    }

    public void defend(Enemy[] enemies, Warrior warrior) {

    }

    public void usePotions(Enemy[] enemies, Warrior warrior) {

    }

    @Override
    public void changeEquipments() {
        super.changeEquipments();
    }
}
