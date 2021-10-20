package entities;

import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Warrior
 * @author Lucas Gomes
 */
public class Warrior extends Persona{

    public Warrior(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<EquipmentsEnum> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }

    @Override
    public int attack(int enemyLife, Persona warrior) {
        return enemyLife - warrior.getAttackPoint();
    }

    @Override
    public int defend(int warriorHp, Persona warrior) {
        if((warriorHp + warrior.getDefensePoint()) <= 100) {
            return warriorHp + warrior.getDefensePoint();
        }
        else {
            return 100;
        }
    }

    @Override
    public int usePotions(int enemyLife, Persona warrior) {
        return (int) (enemyLife - warrior.getAttackPoint() * 1.10);
    }
}
