package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int creed = RPG_Game.random.nextInt(2, 6) * this.getDamage();
        boss.setHealth(boss.getHealth() - creed);
        System.out.println("Warrior " + this.getName() + " hit critically " + creed);
    }
}
