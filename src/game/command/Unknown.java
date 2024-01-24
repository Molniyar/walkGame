package game.command;

import game.Game;
import game.Player;

public class Unknown extends Command{

    @Override
    public void process(Game game, Player player, String args) throws Exception {
        System.out.println("неизвестная или неполная команда");
    }
}
