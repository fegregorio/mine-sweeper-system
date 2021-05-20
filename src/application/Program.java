package application;

import gamefield.Game;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game gameField = new Game(10, 10, 10);

        UI.printField(gameField.tiles());
        String action = UI.readLine(sc);

        gameField.generate(action);
        gameField.makeAction(action);
        gameField.openZeros();

        while (!gameField.isGameOver()) {

            UI.printField(gameField.tiles());

            action = UI.readLine(sc);
            gameField.makeAction(action);
            gameField.openZeros();
        }
    }
}
