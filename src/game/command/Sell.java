package game.command;

import game.Game;
import game.Inventory;
import game.Player;
import game.Thing;

public class Sell extends Command{
    @Override
    public void process(Game game, Player player, String thingName) {
        Inventory inventory = player.getInventory();
        Thing item = inventory.find(thingName);
        if (item == null){
            if (inventory.hasAny()) {
                System.out.println("Нет такого предмета, возможные предметы: ");
                inventory.showAllowedItems();
            }
            else System.out.println("У вас нет предметов чтобы их продавать");
            return;
        }
        if (item.getCount() == 0) {
            System.out.println("Нет такого предмета");
            return;
        }
        item.addCount(-1);
        inventory.addCount("goldCoin", item.goldPrice);
        inventory.addCount("silverCoin", item.silverPrice);
        System.out.println("Вы успешно продали " + item.getTitle());
    }
}
