package game.command;


import game.Game;
import game.Player;

import java.util.Map;
import java.util.TreeMap;

public class List extends Command{
    Map<String, Command> commandList = new TreeMap<>();

    public void addCommand(String name, Command command) {
        commandList.put(name, command);
    }

    @Override
    final public void process(Game game, Player player, String commandLine) throws Exception {
        String[] args = commandLine.split(" ", 2);
        String commandName = args[0];

        Command command = commandList.get(commandName);
        if (command == null){
            System.out.println("Неизвестная команда, возможные команды:" + commandList.keySet());
        }
        else command.process(game, player, args.length>1? args[1]:"");
    }
}









