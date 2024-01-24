package game.command;

import game.Game;
import game.Inventory;
import game.Player;
import game.Thing;

import java.util.Objects;

public class Craft extends Command {
    @Override
    public void process(Game game, Player player, String itemName) {
        Thing item = Inventory.all.find(itemName);
        if (item == null) {
            System.out.println("Нет такого предмета");
            return;
        }
        if (!item.canCraft()) {
            System.out.println("этот предмет нельзя крафтить");
            return;
        }

        item.craft(player);
        /*
        Inventory inventory = player.getInventory();
        if (Objects.equals(itemName, "healthPotion")){
            if (inventory.getCount("mint") > 1 && inventory.getCount("waterBottle") > 0){
                System.out.println("Вы скрафтили зелье исцеления");
                inventory.addCount("mint" , -2);
                inventory.addCount("waterBottle", -1);
                inventory.addCount("healthPotion", 1);
            }
            else System.out.println("У вас недостаточно ингредиентов");
        }
        else System.out.println("Этот предмет нельзя скрафтить, можно скрафтить только зелье исцеления (healthPotion)");
         */
    }
}
