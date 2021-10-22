package entities;

import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Warrior
 * @author Lucas Gomes
 */
public class Warrior extends Persona implements PersonaSkills{

    public Warrior(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<EquipmentsEnum> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }

    @Override
    public Integer attack(Enemy enemy) {
        return enemy.getLifePoint() - this.getAttackPoint();
    }

    @Override
    public Integer defend() {
        if((this.getLifePoint() + this.getDefensePoint()) <= 100) {
            return this.getLifePoint() + this.getDefensePoint();
        }
        else {
            return 100;
        }
    }

    @Override
    public Integer usePotions(Enemy enemy) {
        return (int) (enemy.getLifePoint() - this.getAttackPoint() * 1.10);
    }
}
