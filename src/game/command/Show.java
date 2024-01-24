package game.command;

import game.Game;
import game.Inventory;
import game.Player;

import java.util.Objects;

public class Show extends Command{
    @Override
    public void process(Game game, Player player, String arg) {
        Inventory inventory = player.getInventory();
        if (Objects.equals(arg, "progress")){
            System.out.println("вы находитесь на " + player.getProgress() + " клетке");
        }
        else if (Objects.equals(arg, "health")){
            System.out.println("сейчас у вас " + player.getHealth() + " здоровья");
        }
        else if (Objects.equals(arg, "items") || Objects.equals(arg, "inventory")){
            inventory.showItems();
        }
        else if (Objects.equals(arg, "map")){
            game.getLevel().show();
        }
    }
}
