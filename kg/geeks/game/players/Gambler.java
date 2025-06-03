package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Gambler extends Hero {
    public Gambler(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.GAMBLE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        int dice1 = RPG_Game.random.nextInt(6) + 1;
        int dice2 = RPG_Game.random.nextInt(6) + 1;

        if (dice1 == dice2) {

            int damage = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damage);
            System.out.println("Лудоман " + getName() + " выбросил " + dice1 + " и " + dice2 +
                    "! Критический удар боссу: " + damage);
        } else {

            int damage = dice1 + dice2;
            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];


            while (randomHero == this || randomHero.getHealth() <= 0) {
                randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            }

            randomHero.setHealth(randomHero.getHealth() - damage);
            System.out.println("Лудоман " + getName() + " выбросил " + dice1 + " и " + dice2 +
                    "! Неудача! Герой " + randomHero.getName() + " теряет " + damage + " HP");
        }
    }
}
