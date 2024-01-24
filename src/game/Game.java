package game;

import game.command.*;

import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game {
    private final Scanner input;
    Level level = new Level();
    private final Player[] players;
    Inventory store = new Inventory();
    Command commands = new Main();

    public Game(Scanner input, Player[] players) {
        this.input = input;
        this.players = players;
        store.append(Inventory.all);
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество игроков от двух до пяти");
        int playerCount = input.nextInt();
        input.nextLine();
        if (playerCount < 2) {
            playerCount = 2;
            System.out.println("количество игроков не может быть меньше двух, количество игроков будет равно двум.");
        }
        if (playerCount > 5) {
            playerCount = 5;
            System.out.println("количество игроков не может быть больше пяти, количество игроков будет равно пяти.");
        }
        Player[] players = new Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Введите имя " + (i + 1) + "-го игрока: ");
            players[i] = new Player(i, input.nextLine());
        }
        Game game = new Game(input, players);
        game.run();
    }
    private void run() throws Exception {
        level.mapGeneration();

        while (true){
            for (Player player: players){

                System.out.println("Сейчас ходит: " + player.userName);
                System.out.println("чтобы пропустить ход, напишите: pass");
                String x1 = input.nextLine();
                if (Objects.equals(x1, "pass")) {
                    System.out.println("Вы пропустили ход");
                }
                else {
                    int low = 1;
                    int high = 6;
                    int v = low + (int) (Math.random() * (high - low + 1));
                    System.out.println("Вы ходите на " + v + " клеток");
                    player.progress += v;
                    if (player.progress >= 100){
                        System.out.println("Поздравляем, " + player.userName + " выиграл(а)");
                        return;
                    }
                    level.processPlayer(player);
                }
                System.out.println("Напишите buy что бы купить предмет или напишите use что бы его использовать.");
                System.out.println("Возможные предметы: health potion, jumpForward");
                String commandLine = input.nextLine();
                if (!commandLine.isEmpty()) {
                    commands.process(this, player, commandLine);
                }
                if (player.progress >= 100){
                    System.out.println("Поздравляем, " + player.userName + " выиграл(а)");
                    return;
                }
            }
        }
    }
    public Inventory getStore() {return store;}
    public Level getLevel() {return level;}
    public Scanner getInput() {return input;}

    public void exit() {return;}
}