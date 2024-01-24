package game.command;

import game.Game;
import game.Player;
import game.Thing;

public class Use extends Command{
    @Override
    public void process(Game game, Player player, String thingName) {
        Thing item = player.getInventory().find(thingName);
        if (item == null) {
            System.out.println("Нет такого предмета");
            return;
        }
        if (!item.canUse()) {
            System.out.println("этот предмет нельзя использовать");
            return;
        }
        item.use(player);
    }
}
