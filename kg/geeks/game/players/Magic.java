package kg.geeks.game.players;

public class Magic extends Hero {
    private int boostAmount = 5;
    private int boostRounds = 4;

    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boostRounds > 0) {
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    hero.setDamage(hero.getDamage() + boostAmount);
                }
            }
            System.out.println("Magic " + getName() + " увеличил атаку всех героев на " + boostAmount);
            boostRounds--;
        }
    }
}
