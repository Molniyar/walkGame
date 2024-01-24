package game.command;

public class Main extends List{
    public Main(){
        addCommand("buy"  , new Buy   ());
        addCommand("sell" , new Sell  ());
        addCommand("use"  , new Use   ());
        addCommand("show" , new Show  ());
        addCommand("craft", new Craft ());
        addCommand("cheat", new Cheat ());
        addCommand("exit" , new Exit  ());
    }
}
