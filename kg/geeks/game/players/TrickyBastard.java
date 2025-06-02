package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class TrickyBastard extends Hero {
    private int fakeDeathRound = -1;
    private boolean abilityUsed = false;

    public TrickyBastard(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.FAKE_DEATH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!abilityUsed && RPG_Game.random.nextBoolean()) {
            fakeDeathRound = RPG_Game.roundNumber;
            abilityUsed = true;
            System.out.println("TrickyBastard " + getName() + " притворился мертвым в раунде " + fakeDeathRound);
        }
    }

    public boolean isFakingDeath(int currentRound) {
        return fakeDeathRound == currentRound;
    }

    @Override
    public void setHealth(int health) {
        if (!isFakingDeath(RPG_Game.roundNumber)) {
            super.setHealth(health);
        }
    }

    @Override
    public void attack(Boss boss) {
        if (!isFakingDeath(RPG_Game.roundNumber)) {
            super.attack(boss);
        }
    }
}