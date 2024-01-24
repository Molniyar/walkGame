package game.command;

import game.Game;
import game.Player;

import java.util.Objects;

public class Exit extends Command{

    @Override
    public void process(Game game, Player player, String args) throws Exception {
        System.out.println("Вы уверены что хотите выйти из игры?");
        String accept = game.getInput().nextLine();
        if (Objects.equals(accept, "y") || Objects.equals(accept, "yes")){
            throw new Exception("Число должно быть больше 1!");
        }
    }
}
