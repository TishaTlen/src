package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    public static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Artem", 1000, 50);
        Warrior warrior1 = new Warrior("Ahiles", 290, 10);
        Warrior warrior2 = new Warrior("Hercules", 280, 15);
        Magic magic = new Magic("Potter", 270, 10);
        Berserk berserk = new Berserk("Guts", 260, 10);
        Medic doc = new Medic("Lobanov", 250, 5, 15);
        Medic assistant = new Medic("Junior", 300, 5, 5);
        Avrora avrora = new Avrora("Avrora", 240, 12);
        Druid druid = new Druid("Druid", 230, 8);
        TrickyBastard tricky = new TrickyBastard("Tricky", 220, 10);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, avrora, druid, tricky};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        System.out.println("ROUND " + roundNumber + " ----------- ");
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0 &&
                    hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}