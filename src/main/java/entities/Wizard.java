package entities;

import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Wizard
 * @author Lucas Gomes
 */
public class Wizard extends Persona {

    public Wizard(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<EquipmentsEnum> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }

    @Override
    public int attack(int enemyLife, Persona wizard) {
        return enemyLife - wizard.getAttackPoint();
    }

    @Override
    public int defend(int wizardHp, Persona wizard) {
        if((wizardHp + wizard.getDefensePoint()) <= 100) {
            return wizardHp + wizard.getDefensePoint();
        }
        else {
            return 100;
        }
    }

    @Override
    public int usePotions(int enemyLife, Persona wizard) {
        return (int) (enemyLife - wizard.getAttackPoint() * 1.15);
    }
}
