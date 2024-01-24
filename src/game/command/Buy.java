package game.command;

import game.Game;
import game.Inventory;
import game.Player;
import game.Thing;

public class Buy extends Command{
    @Override
    public void process(Game game, Player player, String thingName) {
        Thing shopItem = game.getStore().find(thingName);
        if (shopItem == null) {
            System.out.println("Нет такого предмета, возможные предметы: ");
            game.getStore().showAllowedItems();
            return;
        }
        Inventory inventory = player.getInventory();
        if (inventory.getCount("goldCoin") >= shopItem.goldPrice && inventory.getCount("silverCoin") >= shopItem.silverPrice) {
            inventory.add(shopItem, 1);
            inventory.addCount("goldCoin", -shopItem.goldPrice);
            inventory.addCount("silverCoin", -shopItem.silverPrice);
            System.out.println("Вы успешно приобрели " + shopItem.getTitle());
        }
        else System.out.println("Недостаточно денег");
    }
}
