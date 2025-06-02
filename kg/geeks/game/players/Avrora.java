package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Avrora extends Hero {
    private boolean isInvisible = false;
    private int invisibleRounds = 2;
    private int storedDamage = 0;
    private boolean abilityUsed = false;

    public Avrora(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.INVISIBILITY);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!abilityUsed && getHealth() < getHealth() * 0.3) {
            isInvisible = true;
            abilityUsed = true;
            System.out.println("Avrora " + getName() + " активировала невидимость на 2 раунда!");
        }

        if (isInvisible && invisibleRounds > 0) {
            storedDamage += boss.getDamage();
            invisibleRounds--;
            if (invisibleRounds == 0) {
                isInvisible = false;
                boss.setHealth(boss.getHealth() - storedDamage);
                System.out.println("Avrora " + getName() + " вернула весь полученный урон: " + storedDamage);
            }
        }
    }

    @Override
    public void setHealth(int health) {
        if (!isInvisible) {
            super.setHealth(health);
        }
    }
}