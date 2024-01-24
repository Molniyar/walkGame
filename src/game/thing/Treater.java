package game.thing;

import game.Player;

public class Treater extends Usable{
    int addHealth = 2;

    public Treater(String id, String title, int count, int goldPrice, int silverPrice, int addHealth) {
        super(id, title, count, goldPrice, silverPrice);
        this.addHealth = addHealth;
    }


    @Override
    protected void useAction(Player player) {
        player.treat(addHealth);
    }

}
