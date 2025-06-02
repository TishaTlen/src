package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Druid extends Hero {
    private boolean abilityUsed = false;

    public Druid(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SUMMON);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!abilityUsed) {
            int chance = RPG_Game.random.nextInt(2);
            if (chance == 0) {

                for (Hero hero : heroes) {
                    if (hero instanceof Medic) {
                        int currentHeal = ((Medic) hero).getHealPoints();
                        int newHealPoints = (int)(currentHeal * 1.5);
                        ((Medic) hero).setHealPoints(newHealPoints);
                        System.out.println("Druid " + getName() + " призвал ангела! Лечение медика увеличено до " + newHealPoints);
                    }
                }
            } else {

                if (boss.getHealth() < boss.getHealth() * 0.5) {
                    int newDamage = (int)(boss.getDamage() * 1.5);
                    boss.setDamage(newDamage);
                    System.out.println("Druid " + getName() + " призвал ворона! Урон босса увеличен до " + newDamage);
                }
            }
            abilityUsed = true;
        }
    }
}