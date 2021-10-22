package entities;

import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Wizard
 * @author Lucas Gomes
 */
public class Wizard extends Persona implements PersonaSkills{

    public Wizard(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<EquipmentsEnum> inventory) {
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
        return (int) (enemy.getLifePoint() - this.getAttackPoint() * 1.15);
    }
}
