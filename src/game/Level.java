package game;

import java.util.Objects;

public class Level {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //           0000000001111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990
    //           1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
    String omap=".....cCc1n.cK3.n...C..1.c...CC.c.Kn........c.....34............Cn............K23........c......n....";
    private String map = "";

    public void mapGeneration() {
        map = ".";
        for (int i = 1; i < 98; i++){
            int random = (int) Math.rint(Math.random() * 100);
            String s;
            switch (random){
                case 1, 2, 3            -> s = "c";
                case 4, 5, 6, 7         -> s = "s";
                case 8, 9, 10, 11       -> s = "S";
                case 12, 13, 14         -> s = "C";
                case 15, 16, 17, 18, 19 -> s = "n";
                case 20, 21, 22         -> s = "K";
                case 23, 24             -> s = "1";
                case 25, 26, 27         -> s = "2";
                case 28, 29             -> s = "3";
                case 30                 -> s = "4";
                case 31, 32             -> s = "d";
                default                 -> s = ".";
            }
            map = map + s;
        }
        map = map + ".";

    }
    public void show() {
        System.out.println(ANSI_YELLOW + "c" + ANSI_RESET + " - золотая монета, s - серебряная монета, " + ANSI_GREEN + "n" + ANSI_RESET + " - природный уголок");
        System.out.println(ANSI_RED + "1, 2, 3, 4" + ANSI_RESET + " - получение урона (в зависимости от цифры)" + ANSI_RED_BACKGROUND + "K" + ANSI_RESET + " - смертоносная клетка");
        String colourMap = "";
        //colourMap = colourMap.replace("n" , ANSI_GREEN_BACKGROUND + "n" + ANSI_RESET);
        //colourMap = colourMap.replace("K" , ANSI_RED_BACKGROUND + "K" + ANSI_RESET);
        //colourMap = colourMap.replace("d" , ANSI_CYAN + "d" + ANSI_RESET);
        //colourMap = colourMap.replace("1" , ANSI_RED + "1" + ANSI_RESET);
        //colourMap = colourMap.replace("2" , ANSI_RED + "2" + ANSI_RESET);
        //colourMap = colourMap.replace("3" , ANSI_RED + "3" + ANSI_RESET);
        //colourMap = colourMap.replace("4" , ANSI_RED + "4" + ANSI_RESET);
        //colourMap = colourMap.replace("c" , ANSI_YELLOW + "c" + ANSI_RESET);
        //colourMap = colourMap.replace("C" , ANSI_YELLOW + "C" + ANSI_RESET);
        for (int i = 0; i < map.length(); i++){
            switch (map.charAt(i)){
                case 'n' -> colourMap += ANSI_GREEN + "n" + ANSI_RESET;
                case 'K' -> colourMap += ANSI_RED_BACKGROUND + "K" + ANSI_RESET;
                case 'd' -> colourMap += ANSI_CYAN + "d" + ANSI_RESET;
                case '1' -> colourMap += ANSI_RED + "1" + ANSI_RESET;
                case '2' -> colourMap += ANSI_RED + "2" + ANSI_RESET;
                case '3' -> colourMap += ANSI_RED + "3" + ANSI_RESET;
                case '4' -> colourMap += ANSI_RED + "4" + ANSI_RESET;
                case 'c' -> colourMap += ANSI_YELLOW + "c" + ANSI_RESET;
                case 'C' -> colourMap += ANSI_YELLOW + "C" + ANSI_RESET;
                case 's' -> colourMap += ANSI_WHITE + "s" + ANSI_RESET;
                case 'S' -> colourMap += ANSI_WHITE + "S" + ANSI_RESET;
                case '.' -> colourMap += ANSI_WHITE + "." + ANSI_RESET;
            }
        }
        System.out.println(colourMap);

        //System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        //System.out.println(ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + ANSI_RESET);
        //System.out.println(ANSI_RED + "This text has red text but a default background!" + ANSI_RESET);
        //System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "This text has a green background and red text!" + ANSI_RESET);

    }

    public void processPlayer(Player player) {
        switch(map.charAt(player.progress - 1))
        {
            case 'n':
                System.out.println("Вы наткнулись на природный уголок");
                int lowLoot = 1;
                int highLoot = 7;
                int loot = lowLoot + (int) (Math.random() * (highLoot - lowLoot + 1));
                switch (loot){
                    case 1: player.inventory.addCount("mint", 1); player.inventory.addCount("apple", 1); player.inventory.addCount("waterBottle", 1);break;
                    case 2: player.inventory.addCount("apple", 2);break;
                    case 3: player.inventory.addCount("mint", 2); player.inventory.addCount("apple", 1);break;
                    case 4: player.inventory.addCount("mint", 2);break;
                    case 5: player.inventory.addCount("mint", 3);break;
                    case 6: player.inventory.addCount("waterBottle", 2);break;
                    case 7: player.inventory.addCount("crystal", 1);player.inventory.addCount("waterBottle", 1);break;
                }
                break;
            case 'K': player.kill();break;
            case 'c': System.out.println("Вы нашли одну золотую монету"); player.inventory.addCount("goldCoin", 1 );break;
            case 'C': System.out.println("Вы нашли три золотых монеты"); player.inventory.addCount("goldCoin", 3);break;
            case 's': System.out.println("Вы нашли одну серебрянную монету"); player.inventory.addCount("silverCoin", 1) ;break;
            case 'S': System.out.println("Вы нашли три серебрянных монеты"); player.inventory.addCount("silverCoin",3);break;
            case 'd': System.out.println("Вы нашли кристалл"); player.inventory.addCount("crystal", 1);break;
            case '1': player.damage(1);break;
            case '2': player.damage(2);break;
            case '3': player.damage(3);break;
            case '4': player.damage(4);break;
            case '.': System.out.println("Вы остановились на пустой клетке.");break;
            default: System.out.println("Ошибка генерации карты, незнакомая клетка: " + map.charAt(player.progress));
        }
    }
}
