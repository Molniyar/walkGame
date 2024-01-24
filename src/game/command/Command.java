package game.command;

import game.Game;
import game.Player;

public abstract class Command {
    public abstract void process(Game game, Player player, String args) throws Exception;

}
