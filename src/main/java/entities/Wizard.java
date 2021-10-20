package entities;

import java.util.List;

public class Wizard extends Persona {

    public Wizard(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<EquipmentsEnum> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }

    public int wizardAttack(int enemyLife, Wizard wizard) {
        return enemyLife - wizard.getAttackPoint();
    }

    public int wizardDefend(int wizardHp, Wizard wizard) {
        if((wizardHp + wizard.getDefensePoint()) <= 100) {
            return wizardHp + wizard.getDefensePoint();
        }
        else {
            return 100;
        }
    }

    public int wizardUsePotions(int enemyLife, Wizard wizard) {
        return (int) (enemyLife + wizard.getAttackPoint() * 1.10);
    }

    @Override
    public void changeEquipments() {
        super.changeEquipments();
    }
}
