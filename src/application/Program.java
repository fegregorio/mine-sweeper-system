package application;

import gamefield.Game;
import gamefield.GameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game gameField = new Game(10, 10, 10);

        try {
            while (!gameField.isGameOver()) {

                UI.clearScreen();
                UI.printMatch(gameField);
                String action = UI.readLine(sc);

                if (gameField.turn() == 1) {
                    gameField.generate(action);
                }

                gameField.makeAction(action);
                gameField.openZeros();

                gameField.next();
            }

            UI.clearScreen();
            UI.printMatch(gameField);
            System.out.println("Game over.");
        }
        catch (GameException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
