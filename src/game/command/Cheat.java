package game.command;

import game.command.cheat.Give;
import game.command.cheat.Teleport;
public class Cheat extends List{
    public Cheat(){
        addCommand("tp"  , new Teleport());
        addCommand("give", new Give    ());
    }
}
