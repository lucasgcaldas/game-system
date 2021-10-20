package entities;

public class Enemy {

    private Integer lifePoint;
    private Integer attackPoint;
    private Integer defensePoint;

    public Enemy(Integer lifePoint, Integer attackPoint, Integer defensePoint) {
        this.lifePoint = lifePoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
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

    public int attack(int personaHp, Enemy enemy) {
        return personaHp - enemy.getAttackPoint();
    }

    public int defend(int enemyHp, Enemy enemy) {
        return enemyHp + enemy.getDefensePoint();
    }
}
