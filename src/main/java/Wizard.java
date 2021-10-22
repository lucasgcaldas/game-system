import java.util.List;

/**
 * Class that extends Persona and
 * is responsible for instantiate
 * a Wizard
 *
 * @author Lucas Gomes
 */
public class Wizard extends Persona implements PersonaSkills {

    public Wizard(Integer lifePoint, Integer attackPoint, Integer defensePoint, List<Equipment> inventory) {
        super(lifePoint, attackPoint, defensePoint, inventory);
    }

    @Override
    public Integer attack(Enemy enemy) {
        int upgradeAttack = 0;
        for (int i = 0; i < this.getInventory().size(); i++) {
            upgradeAttack += this.getInventory().get(i).getImproveDamage();
        }
        return enemy.getLifePoint() - this.getAttackPoint() - upgradeAttack;
    }

    @Override
    public Integer defend(Enemy enemy) {
        int upgradeDefend = 0;
        for (int i = 0; i < this.getInventory().size(); i++) {
            upgradeDefend += this.getInventory().get(i).getReduceDamage();
        }
        return this.getLifePoint() + this.getDefensePoint() - enemy.getAttackPoint() + upgradeDefend;
    }

    @Override
    public Integer usePotions(Enemy enemy) {
        return (int) (enemy.getLifePoint() - this.getAttackPoint() * 1.15);
    }
}
