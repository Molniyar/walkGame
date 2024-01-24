package saves.save01;

import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static class Player {
        int progress = 1;
        String userName;
        int health = 5;
        int coinCount = 0;
        int healthPotionCount = 0;
        int jumpForwardCount = 0;
        int jumpBackCount = 0;
        int appleCount = 0;
        int mintCount = 0;
        int waterBottleCount = 0;
        int crystalCount = 0;
        //int totemOfUndieing = 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Введите имя первого игрока: ");
        player1.userName = input.nextLine();
        System.out.println("Введите имя второго игрока: ");
        player2.userName = input.nextLine();

        while (player1.progress < 100 || player2.progress < 100){

                System.out.println("Сейчас ходит: " + player1.userName);
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
                    player1.progress += v;
                    if (player1.progress >= 100){
                        System.out.println("Поздравляем, " + player1.userName + " выиграл(а)");
                        return;
                    }
                    if (player1.progress == 10 || player1.progress == 16 || player1.progress == 35 || player1.progress == 65 || player1.progress == 96) {
                        System.out.println("Вы наткнулись на природный уголок");
                        int lowLoot = 1;
                        int highLoot = 6;
                        int loot = lowLoot + (int) (Math.random() * (highLoot - lowLoot + 1));
                        switch (loot){
                            case 1: {player1.mintCount++; player1.appleCount++; player1.waterBottleCount++;}
                            case 2: {player1.mintCount++; player1.appleCount += 2;}
                            case 3: {player1.mintCount += 2; player1.appleCount++;}
                            case 4: {player1.mintCount += 2;}
                            case 5: player1.mintCount += 3;
                            case 6: player1.waterBottleCount += 2;
                        }
                    }
                    switch (player1.progress){
                        case 13, 78, 34: {
                                System.out.println("Вы умерли");

                            break;
                        }
                        case 89, 6, 8, 32, 12, 44, 25: System.out.println("Вы нашли одну монету"); player1.coinCount++ ;break;
                        case 7, 64, 30, 29, 20: System.out.println("Вы нашли три монеты"); player1.coinCount += 3;break;
                        case 9, 23: System.out.println("Вы получили урон");player1.health-- ;break;
                        case 79: System.out.println("Вы получили урон");player1.health -= 2;break;
                        case 80, 50, 14: System.out.println("Вы получили урон");player1.health -= 3;break;
                        case 51: System.out.println("Вы получили урон");player1.health -= 4;break;
                        case 10, 16, 35, 65, 96:;
                        default: System.out.println("Вы остановились на пустой клетке.");break;
                    }
                    if (player1.health <= 0){
                            System.out.println("Вы умерли");

                    }

                }
                System.out.println("Напишите buy что бы купить предмет или напишите use что бы его использовать.");
                System.out.println("Возможные предметы: health potion, jumpForward");
                String command1 = input.nextLine();

                if (Objects.equals(command1, "buy health potion")){//                                                buy
                    if (player1.coinCount >= 2) {
                        System.out.println("Вы успешно приобрели зелье исцеления");
                        player1.healthPotionCount++;
                        player1.coinCount -= 2;
                    }
                    else System.out.println("Недостаточно денег");
                }
                else if (Objects.equals(command1, "buy jumpForward")){
                    if (player1.coinCount >= 3) {
                        System.out.println("Вы успешно приобрели прыжок вперед");
                        player1.jumpForwardCount++;
                        player1.coinCount -= 3;
                    }
                    else System.out.println("Недостаточно денег");
                }
                else if (Objects.equals(command1, "buy jumpBack")){
                    if (player1.coinCount >= 2) {
                        System.out.println("Вы успешно приобрели прыжок назад");
                        player1.jumpBackCount++;
                        player1.coinCount -= 3;
                    }
                    else System.out.println("Недостаточно денег");
                }
                else if (Objects.equals(command1, "buy water bottle")){
                    if (player1.coinCount > 0) {
                        System.out.println("Вы успешно приобрели бутылку с водой");
                        player1.waterBottleCount++;
                        player1.coinCount -= 1;
                    }
                    else System.out.println("Недостаточно денег");
                }

                if (Objects.equals(command1, "sell health potion")){//                                               sell
                    if (player1.healthPotionCount > 0) {
                        System.out.println("Вы успешно продали зелье исцеления");
                        player1.healthPotionCount--;
                        player1.coinCount += 2;
                    }
                    else System.out.println("Нет зелья исцеления");
                }
                else if (Objects.equals(command1, "sell jumpForward")){
                    if (player1.jumpForwardCount > 0) {
                        System.out.println("Вы успешно продали прыжок вперед");
                        player1.jumpForwardCount--;
                        player1.coinCount += 3;
                    }
                    else System.out.println("Нет прыжка вперед");
                }
                else if (Objects.equals(command1, "sell jumpBack")){
                    if (player1.jumpBackCount > 0) {
                        System.out.println("Вы успешно продали прыжок назад");
                        player1.jumpBackCount--;
                        player1.coinCount += 3;
                    }
                    else System.out.println("Нет прыжка назад");
                }
                else if (Objects.equals(command1, "sell water bottle")){
                    if (player1.waterBottleCount > 0) {
                        System.out.println("Вы успешно продали бутылку с водой");
                        player1.waterBottleCount--;
                        player1.coinCount += 1;
                    }
                    else System.out.println("Нет бутылки с водой");
                }
                else if (Objects.equals(command1, "sell apple")){
                    if (player1.appleCount > 0) {
                        System.out.println("Вы успешно продали яблоко");
                        player1.appleCount--;
                        player1.coinCount += 1;
                    }
                    else System.out.println("Нет яблока");
                }


                else if (Objects.equals(command1, "use health potion")){//                                           use
                    if (player1.healthPotionCount > 0) {
                        System.out.println("Вы выпили зелье исцеления");
                        player1.healthPotionCount--;
                        player1.health += 2;
                    }
                    else System.out.println("У вас нет зелья исцеления");
                    if (player1.health > 5){
                        player1.health = 5;
                    }
                }
                else if (Objects.equals(command1, "use jumpForward")){
                    if (player1.jumpForwardCount > 0) {
                        System.out.println("Вы использовали прыжок вперед");
                        player1.jumpForwardCount--;
                        player1.progress += 5;
                    }
                    else System.out.println("У вас нет прыжка вперед");

                    if (player1.progress > 100){
                        player1.progress = 100;
                    }
                }
                else if (Objects.equals(command1, "use jumpBack")){
                    if (player1.jumpBackCount > 0) {
                        System.out.println("Вы использовали прыжок назад");
                        player1.jumpBackCount--;
                        player1.progress -= 5;
                    }
                    else System.out.println("У вас нет прыжка назад");

                    if (player1.progress < 1){
                        player1.progress = 1;
                    }
                }

                else if (Objects.equals(command1, "give coins")){//                                                  cheat commands
                    System.out.println("Сколько монет вы хотите?");
                    int coins = input.nextInt();
                    player1.coinCount += coins;
                }
                else if (Objects.equals(command1, "tp")){
                    int tp = input.nextInt();
                    player1.progress = tp;
                }

                else if (Objects.equals(command1, "show progress")){//                                               show
                    System.out.println("вы находитесь на " + player1.progress + " клетке");
                }
                else if (Objects.equals(command1, "show coins")){
                    System.out.println("сейчас у вас " + player1.coinCount + " монет");
                }
                else if (Objects.equals(command1, "show health")){
                    System.out.println("сейчас у вас " + player1.health + " здоровья");
                }
                else if (Objects.equals(command1, "show items") || Objects.equals(command1, "show inventory")){
                    System.out.println(player1.coinCount + " " + " монет");
                    System.out.println(player1.healthPotionCount + " " + " зелей исцеления");
                    System.out.println(player1.jumpForwardCount + " " + " прыжков вперед");
                    System.out.println(player1.jumpBackCount + " " + " прыжков назад");
                    System.out.println(player1.appleCount + " " + " яблок");
                    System.out.println(player1.jumpBackCount + " " + " мяты");
                    System.out.println(player1.waterBottleCount + " " + " бутылок с водой");
                }

                else if (Objects.equals(command1, "craft ")){//                                                      craft
                    if (player1.mintCount > 1 && player1.waterBottleCount > 0){
                        System.out.println("Вы скрафтили зелье исцеления");
                        player1.mintCount -= 2;
                        player1.waterBottleCount -= 1;
                        player1.healthPotionCount += 1;
                    }
                    else System.out.println("У вас недостаточно ингредиентов");
                }
            if (player1.progress >= 100){
                System.out.println("Поздравляем, " + player1.userName + " выиграл(а)");
                return;
            }


                System.out.println("Сейчас ходит: " + player2.userName);
                System.out.println("чтобы пропустить ход, напишите: pass");
                String x2 = input.nextLine();
            if (Objects.equals(x2, "pass")) {
                System.out.println("Вы пропустили ход");
            }
            else {
                    int low = 1;
                    int high = 6;
                    int v = low + (int) (Math.random() * (high - low + 1));
                    System.out.println("Вы ходите на " + v + " клеток");
                    player2.progress += v;
                    if (player2.progress >= 100) {
                        System.out.println("Поздравляем, " + player2.userName + " выиграл(а)");
                        return;
                    }
                    if (player2.progress == 10 || player2.progress == 16 || player1.progress == 35 || player1.progress == 65 || player2.progress == 96) {
                        System.out.println("Вы наткнулись на природный уголок");
                        int lowLoot = 1;
                        int highLoot = 6;
                        int loot = lowLoot + (int) (Math.random() * (highLoot - lowLoot + 1));
                        switch (loot){
                            case 1: {player2.mintCount++; player2.appleCount++; player2.waterBottleCount++;}
                            case 2: {player2.mintCount++; player2.appleCount += 2;}
                            case 3: {player2.mintCount += 2; player2.appleCount++;}
                            case 4: {player2.mintCount += 2;}
                            case 5: player2.mintCount += 3;
                            case 6: player2.waterBottleCount += 2;
                        }
                    }
                    switch (player2.progress){
                        case 13, 78, 34: System.out.println("Вы умерли на смертоносной клетке."); player2.progress = 0; player2.health = 5;break;
                        case 89, 32, 12, 25: System.out.println("Вы нашли одну монету"); player2.coinCount++ ;break;
                        case 7, 64, 20: System.out.println("Вы нашли три монеты"); player2.coinCount += 3;break;
                        case 9, 23: System.out.println("Вы получили урон");player2.health-- ;break;
                        case 79: System.out.println("Вы получили урон");player2.health -= 2;break;
                        case 80, 50, 14: System.out.println("Вы получили урон");player2.health -= 3;break;
                        case 51: System.out.println("Вы получили урон");player2.health -= 4;break;
                        case 10, 16, 35, 65, 96:;
                        default: System.out.println("Вы остановились на пустой клетке.");break;
                    }
                    if (player1.health <= 0){
                        System.out.println("Вы умерли.");
                        player1.progress = 1;
                    }
                }
                System.out.println("Напишите buy что бы купить предмет или напишите use что бы его использовать.");
                System.out.println("Возможные предметы: health potion, jump");
                String command2 = input.nextLine();

            if (Objects.equals(command2, "buy health potion")){//                                                    buy
                if (player2.coinCount >= 2) {
                    System.out.println("Вы успешно приобрели зелье исцеления");
                    player2.healthPotionCount++;
                    player2.coinCount -= 2;
                }
                else System.out.println("Недостаточно денег");
            }
            else if (Objects.equals(command2, "buy jumpForward")){
                if (player2.coinCount >= 3) {
                    System.out.println("Вы успешно приобрели прыжок вперед");
                    player2.jumpForwardCount++;
                    player2.coinCount -= 3;
                }
                else System.out.println("Недостаточно денег");
            }
            else if (Objects.equals(command2, "buy jumpBack")){
                if (player2.coinCount >= 2) {
                    System.out.println("Вы успешно приобрели прыжок назад");
                    player2.jumpBackCount++;
                    player2.coinCount -= 3;
                }
                else System.out.println("Недостаточно денег");
            }
            else if (Objects.equals(command2, "buy water bottle")){
                if (player2.coinCount > 0) {
                    System.out.println("Вы успешно приобрели бутылку с водой");
                    player2.waterBottleCount++;
                    player2.coinCount -= 1;
                }
                else System.out.println("Недостаточно денег");
            }

            if (Objects.equals(command2, "sell health potion")){//                                                   sell
                if (player2.healthPotionCount > 0) {
                    System.out.println("Вы успешно продали зелье исцеления");
                    player2.healthPotionCount--;
                    player2.coinCount += 2;
                }
                else System.out.println("Нет зелья исцеления");
            }
            else if (Objects.equals(command2, "sell jumpForward")){
                if (player2.jumpForwardCount > 0) {
                    System.out.println("Вы успешно продали прыжок вперед");
                    player2.jumpForwardCount--;
                    player2.coinCount += 3;
                }
                else System.out.println("Нет прыжка вперед");
            }
            else if (Objects.equals(command2, "sell jumpBack")){
                if (player2.jumpBackCount > 0) {
                    System.out.println("Вы успешно продали прыжок назад");
                    player2.jumpBackCount--;
                    player2.coinCount += 3;
                }
                else System.out.println("Нет прыжка назад");
            }
            else if (Objects.equals(command2, "sell water bottle")){
                if (player2.waterBottleCount > 0) {
                    System.out.println("Вы успешно продали бутылку с водой");
                    player2.waterBottleCount--;
                    player2.coinCount += 1;
                }
                else System.out.println("Нет бутылки с водой");
            }
            else if (Objects.equals(command2, "sell apple")){
                if (player2.appleCount > 0) {
                    System.out.println("Вы успешно продали яблоко");
                    player2.appleCount--;
                    player2.coinCount += 1;
                }
                else System.out.println("Нет яблока");
            }


            else if (Objects.equals(command2, "use health potion")){//                                               use
                if (player2.healthPotionCount > 0) {
                    System.out.println("Вы выпили зелье исцеления");
                    player2.healthPotionCount--;
                    player2.health += 2;
                }
                else System.out.println("У вас нет зелья исцеления");
                if (player2.health > 5){
                    player2.health = 5;
                }
            }
            else if (Objects.equals(command2, "use jumpForward")){
                if (player2.jumpForwardCount > 0) {
                    System.out.println("Вы использовали прыжок вперед");
                    player2.jumpForwardCount--;
                    player2.progress += 5;
                }
                else System.out.println("У вас нет прыжка вперед");

                if (player2.progress > 100){
                    player2.progress = 100;
                }
            }
            else if (Objects.equals(command2, "use jumpBack")){
                if (player2.jumpBackCount > 0) {
                    System.out.println("Вы использовали прыжок назад");
                    player2.jumpBackCount--;
                    player2.progress -= 5;
                }
                else System.out.println("У вас нет прыжка назад");

                if (player2.progress < 1){
                    player2.progress = 1;
                }
            }

            else if (Objects.equals(command2, "give coins")){//                                                      cheat commands
                System.out.println("Сколько монет вы хотите?");
                int coins = input.nextInt();
                player2.coinCount += coins;
            }
            else if (Objects.equals(command2, "tp")){
                int tp = input.nextInt();
                player2.progress = tp;
            }

            else if (Objects.equals(command2, "show progress")){//                                                   show
                System.out.println("вы находитесь на " + player2.progress + " клетке");
            }
            else if (Objects.equals(command2, "show coins")){
                System.out.println("сейчас у вас " + player2.coinCount + " монет");
            }
            else if (Objects.equals(command2, "show health")){
                System.out.println("сейчас у вас " + player2.health + " здоровья");
            }
            else if (Objects.equals(command2, "show items") || Objects.equals(command2, "show inventory")){
                System.out.println(player2.coinCount + " " + " монет");
                System.out.println(player2.healthPotionCount + " " + " зелей исцеления");
                System.out.println(player2.jumpForwardCount + " " + " прыжков вперед");
                System.out.println(player2.jumpBackCount + " " + " прыжков назад");
                System.out.println(player2.appleCount + " " + " яблок");
                System.out.println(player2.jumpBackCount + " " + " мяты");
                System.out.println(player2.waterBottleCount + " " + " бутылок с водой");
            }

            else if (Objects.equals(command2, "craft ")){//                                                          craft
                if (player2.mintCount > 1 && player2.waterBottleCount > 0){
                    System.out.println("Вы скрафтили зелье исцеления");
                    player2.mintCount -= 2;
                    player2.waterBottleCount -= 1;
                    player2.healthPotionCount += 1;
                }
                else System.out.println("У вас недостаточно ингредиентов");
            }
            if (player2.progress >= 100) {
                System.out.println("Поздравляем, " + player2.userName + " выиграл(а)");
                return;
            }

        }
        if (player1.progress == 100){
            System.out.println("Поздравляем, " + player1.userName + " выиграл(а)");
        }
        else if (player2.progress == 100) {
            System.out.println("Поздравляем, " + player2.userName + " выиграл(а)");
        }
    }
}