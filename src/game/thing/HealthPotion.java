package game.thing;

import game.Game;
import game.Inventory;
import game.Player;

import java.util.Objects;

public class HealthPotion extends Treater{

    public HealthPotion(String id, String title, int count, int goldPrice, int silverPrice) {
        super(id, title, count, goldPrice, silverPrice, 2);
    }

    @Override
    public boolean craft(Player player) {
        Inventory inventory = player.getInventory();
        if (inventory.getCount("mint") < 2 && inventory.getCount("waterBottle") < 1){
            System.out.println("Недостаточно ингредиентов для зелья исцеления, требуемые ингредиенты: мята(mint) * 2, бутылка с водой(waterBottle) * 1");
            return false;
        }
        inventory.addCount("mint", -2);
        inventory.addCount("waterBottle", -1);
        inventory.addCount("healthPotion", 1);
        return true;
    }

    @Override
    public boolean canCraft() {
        return true;
    }

/*
    public void craft() {
        Inventory inventory = player.getInventory();
        if (Objects.equals(itemName, "healthPotion")) {
            if (inventory.getCount("mint") > 1 && inventory.getCount("waterBottle") > 0) {
                System.out.println("Вы скрафтили зелье исцеления");
                inventory.addCount("mint", -2);
                inventory.addCount("waterBottle", -1);
                inventory.addCount("healthPotion", 1);
            } else System.out.println("У вас недостаточно ингредиентов");
        } else
            System.out.println("Этот предмет нельзя скрафтить, можно скрафтить только зелье исцеления (healthPotion)");
    }
 */
}
