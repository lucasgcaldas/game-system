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
        int option = sc.nextInt();
        if (option == 1) {
            Wizard persona = new Wizard(100, 10, 5, null);
            battle(chooseScenery(), persona);
        } else {
            Warrior persona = new Warrior(100, 8, 3, null);
            battle(chooseScenery(), persona);
        }
    }

    public static int chooseScenery() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What scenery do you want start?");
        System.out.println("(1) Desert");
        System.out.println("(2) Forest");
        System.out.println("(3) River");
        return sc.nextInt();
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

    private static int userGameMode(Persona persona) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to change scenery? (1) Yes (2) No");
        int value = sc.nextInt();
        if (value == 1) {
            battle(chooseScenery(), persona);
        }
        System.out.println("What do you want to do?");
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

    public static void battle(int value, Persona persona) {
        chooseItems();
        Random random = new Random();
        List<EquipmentsEnum> equipmentsEnums = new ArrayList<>();
        Enemy enemy1 = new Enemy(random.nextInt((80 - 70) + 1) + 70, random.nextInt((15 - 10) + 1) + 10, random.nextInt((8 - 3) + 1) + 3);
        Enemy enemy2 = new Enemy(random.nextInt((90 - 85) + 1) + 85, random.nextInt((20 - 15) + 1) + 15, random.nextInt((10 - 5) + 1) + 5);
        Enemy[] enemies = new Enemy[]{enemy1, enemy2};
        Integer[] hpEnemy = new Integer[2];
        Scenery scenery = new Scenery(persona, SceneryEnum.values(), enemies);

        System.out.println("You are a " + persona.getClass().getSimpleName() + " and are in the " + scenery.changeScenery(value).toString());

        int personaHp = persona.getLifePoint();
        hpEnemy[0] = enemies[0].getLifePoint();
        hpEnemy[1] = enemies[1].getLifePoint();
        int gameMode;
        while (personaHp > 0 && (hpEnemy[0] > 0 || hpEnemy[1] > 0)) {
            showLife(personaHp, hpEnemy[0], hpEnemy[1]);
            gameMode = userGameMode(persona);
            switch (gameMode) {
                case 1:
                    System.out.println("You applied an attack");
                    hpEnemy[0] = persona.attack(hpEnemy[0], persona);
                    hpEnemy[1] = persona.attack(hpEnemy[1], persona);
                    break;
                case 2:
                    System.out.println("You defended an attack");
                    personaHp = persona.defend(personaHp, persona);
                    break;
                case 3:
                    System.out.println("You used potions to attack");
                    hpEnemy[0] = persona.usePotions(hpEnemy[0], persona);
                    hpEnemy[1] = persona.usePotions(hpEnemy[1], persona);
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
                        personaHp = enemies[0].attack(personaHp, enemies[0]);
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
                        personaHp = enemies[1].attack(personaHp, enemies[1]);
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
