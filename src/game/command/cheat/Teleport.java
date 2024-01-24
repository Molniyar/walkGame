package game.command.cheat;

import game.Game;
import game.Player;
import game.command.Command;

public class Teleport extends Command {

    @Override
    public void process(Game game, Player player, String args) throws Exception {
        try {
            player.setProgress(Integer.parseInt(args));
        }catch (NumberFormatException e){
            System.out.println("Неправильно задан номер клетки телепортации");
        }
    }
}
