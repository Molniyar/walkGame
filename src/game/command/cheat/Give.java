package game.command.cheat;

import game.Game;
import game.Inventory;
import game.Player;
import game.Thing;
import game.command.Command;

import java.util.Objects;

public class Give extends Command {
    @Override
    public void process(Game game, Player player, String arg) throws Exception {
        Inventory inventory = player.getInventory();

        String[] giveArg = arg.split(" ", 2);

        String name  = giveArg[0];
        int count = 1;
        try {
            count =  giveArg.length < 2? 1:Integer.parseInt(giveArg[1]);
        }

        catch(NumberFormatException e){
            System.out.println("Неправильно задано количество предметов");
            return;
        }


        Thing shopItem = Inventory.all.find(name);

        if (shopItem == null){
            System.out.println("Нет такого предмета, возможные предметы: ");
            Inventory.all.showAllowedItems();
            return;
        }
        Thing item = inventory.add(shopItem, count);
        System.out.println("Получен предмет: " + item.getTitle());
    }
}
