package application;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void choosePersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to be?");
        System.out.println("(1) Wizard");
        System.out.println("(2) Warrior");
        int value = sc.nextInt();
        if (value == 1) {
            battleWizard();
        } else {
            battleWarrior();
        }
    }

    public static List<EquipmentsEnum> chooseItems() {
        Scanner sc = new Scanner(System.in);
        List<EquipmentsEnum> equipments = new ArrayList<>();
        System.out.println("Do you want to choose items? (1) Yes (2) No");
        int yn = sc.nextInt();
        if (yn == 1) {
            System.out.println("What do you want to put in your inventory?");
            System.out.println("(1)" + EquipmentsEnum.ARCHERY);
            System.out.println("(2)" + EquipmentsEnum.ARMOR);
            System.out.println("(3)" + EquipmentsEnum.SWORD);
        }
        return equipments;
    }

    private static int userGameMode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("(1) Attack");
        System.out.println("(2) Defend");
        System.out.println("(3) Use Potions");
        return sc.nextInt();
    }

    private static int enemyGameMode() {
        Random value = new Random();
        return value.nextInt(2) + 1;
    }

    public static void showLife(Integer life, Integer enemyLife1, Integer enemyLife2) {
        System.out.println("--------------------");
        System.out.println("User Life: " + life);
        System.out.println("Enemy1 Life: " + enemyLife1);
        System.out.println("Enemy2 Life: " + enemyLife2);
        System.out.println("--------------------");
    }

    public static void battleWarrior() {
        chooseItems();
        List<EquipmentsEnum> equipmentsEnums = new ArrayList<>();
        Wizard wizard = new Wizard(100, 10, 5, equipmentsEnums);
        Enemy enemy1 = new Enemy(70, 15, 5);
        Enemy enemy2 = new Enemy(80, 20, 2);
        Enemy[] enemies = new Enemy[]{enemy1, enemy2};

        Scenery scenery = new Scenery(wizard, SceneryEnum.values(), enemies);

        while (wizard.getLifePoint() > 0 && (enemy1.getLifePoint() > 0 || enemy2.getLifePoint() > 0)) {
            showLife(wizard.getLifePoint(), enemy1.getLifePoint(), enemy2.getLifePoint());
        }
    }

    public static void battleWizard() {
        chooseItems();
        List<EquipmentsEnum> equipmentsEnums = new ArrayList<>();
        Wizard wizard = new Wizard(100, 10, 5, equipmentsEnums);
        Enemy enemy1 = new Enemy(70, 15, 5);
        Enemy enemy2 = new Enemy(80, 20, 2);
        Enemy[] enemies = new Enemy[]{enemy1, enemy2};
        Integer[] hpEnemy = new Integer[2];
        Scenery scenery = new Scenery(wizard, SceneryEnum.values(), enemies);

        int wizardHp = wizard.getLifePoint();
        hpEnemy[0] = enemies[0].getLifePoint();
        hpEnemy[1] = enemies[1].getLifePoint();
        int gameMode;
        while (wizardHp > 0 && (hpEnemy[0] > 0 || hpEnemy[1] > 0)) {
            showLife(wizardHp, hpEnemy[0], hpEnemy[1]);
            gameMode = userGameMode();
            switch (gameMode) {
                case 1:
                    System.out.println("You applied an attack");
                    hpEnemy[0] = wizard.wizardAttack(hpEnemy[0], wizard);
                    hpEnemy[1] = wizard.wizardAttack(hpEnemy[1], wizard);
                    break;
                case 2:
                    System.out.println("You defended an attack");
                    wizardHp = wizard.wizardDefend(wizardHp, wizard);
                    break;
                case 3:
                    System.out.println("You used potions to attack");
                    hpEnemy[0] = wizard.wizardUsePotions(hpEnemy[0], wizard);
                    hpEnemy[1] = wizard.wizardUsePotions(hpEnemy[1], wizard);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            if (hpEnemy[0] > 0) {
                gameMode = enemyGameMode();
                switch (gameMode) {
                    case 1:
                        System.out.println("The enemy " + 1 + " applied an attack");
                        wizardHp = enemies[0].attack(wizardHp, enemies[0]);
                        break;
                    case 2:
                        System.out.println("The enemy " + 1 + " defended an attack");
                        hpEnemy[0] = enemies[0].defend(hpEnemy[0], enemies[0]);
                        break;
                }
            }
            if (hpEnemy[1] > 0) {
                gameMode = enemyGameMode();
                switch (gameMode) {
                    case 1:
                        System.out.println("The enemy " + 2 + " applied an attack");
                        wizardHp = enemies[1].attack(wizardHp, enemies[1]);
                        break;
                    case 2:
                        System.out.println("The enemy " + 2 + " defended an attack");
                        hpEnemy[1] = enemies[1].defend(hpEnemy[1], enemies[1]);
                        break;
                }
            } else {
                System.out.println("You Win!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int keep = 1;
        while (keep == 1) {
            choosePersona();
            System.out.println("End game! Do you want to continue? (1) Yes (2) No");
            keep = sc.nextInt();
        }
        sc.close();
    }
}
