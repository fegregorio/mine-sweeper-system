package application;

import gamefield.Game;
import gamefield.Tile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GRAY = "\u001B[37m";
    public static final String ANSI_WHITE = "\u001B[97m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_GRAY_BACKGROUND = "\u001B[47m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[107m";


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printMatch(Game gameField) {

        printField(gameField.tiles());

        System.out.printf("Mines left: %d", gameField.minesLeft());
        System.out.printf("%n%n");
    }

    public static void printField(Tile[][] tiles) {

        System.out.print("   ");

        for (int i = 0; i < tiles[0].length; i++) {

            System.out.print((char) ('A' + i));
            System.out.print(" ");
        }

        System.out.println();

        for (int i = 0; i < tiles.length; i++) {

            System.out.printf("%02d ", i + 1);

            for (int j = 0; j < tiles[0].length; j++) {

                switch (tiles[i][j].toString()) {

                    case "•":
                        System.out.print(ANSI_WHITE);
                        break;

                    case "F":
                        System.out.print(ANSI_RED);
                        break;

                    case "0":
                        System.out.print(ANSI_GRAY);
                        break;

                    case "M":
                        System.out.print(ANSI_BLACK);
                        break;

                    default:
                        System.out.print(ANSI_YELLOW);
                }

                System.out.print(tiles[i][j] + ANSI_RESET);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String readLine(Scanner sc) { // input example: [A03 O]

        try {
            String s = sc.nextLine().strip().toUpperCase();

            if (s.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            String row = s.substring(1, 3);
            char column = s.charAt(0);
            char rule = 'N';
            if (s.length() > 3) {
                rule = s.charAt(4);
            }

            return String.format("%s%02d %s", column, Integer.parseInt(row), rule);
        }
        catch (RuntimeException e) {
            throw new InputMismatchException(String.format(
                    "Invalid code. Valid expressions range from %s%02d to %s%02d.", "A", 1, "J", 10));
        }
    }
}
