package game.thing;

import game.Player;
import game.Thing;

public class Usable extends Thing {
    public Usable(String id, String title, int count, int goldPrice, int silverPrice) {
        super(id, title, count, goldPrice, silverPrice);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean use(Player player) {
        if (count > 0) {
            System.out.println("Вы использовали " + title);
            count--;
            useAction(player);
            return true;
        }
        else {
            System.out.println("У вас нет " + title);
            return false;
        }
    }

    protected void useAction(Player player) {

    }
}
