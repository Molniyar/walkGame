package game.thing;

import game.Player;
import game.Thing;

public class Jump extends Usable{
    int jumpLength;

    public Jump(String id, String title, int count, int goldPrice, int silverPrice, int jumpLength) {
        super(id, title, count, goldPrice, silverPrice);
        this.jumpLength = jumpLength;
    }


    @Override
    protected void useAction(Player player) {
        player.jump(jumpLength);
    }
}
