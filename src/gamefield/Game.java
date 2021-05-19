package gamefield;

import java.util.Random;

public class Game {

    private Field field;
    private final int mines;
    private static boolean gameOver;


    public Game(int rows, int columns, int mines) {
        this.field = new Field(rows, columns);
        this.mines = mines;
        gameOver = false;
    }


    public int getMines() { return mines; }
    public boolean isGameOver() { return gameOver; }

    public Tile[][] tiles() {

        return field.getTiles();
    }

    public void makeAction(String code) {

        Position pos = Position.valueOf(code);

        if (code.substring(5).equals("o")) {
            field.tile(pos).open();

            if (field.tile(pos).isMine()) {
                gameOver = true;
            }
        }
        else if (code.substring(5).equals("f")) {
            field.tile(pos).flag();
        }
    }

    public void generate() {

        Position[] minesPos = new Position[mines];
        Random random = new Random();

        for (int i = 0; i < mines; i++) {
            int row = random.nextInt(field.getRows());
            int column = random.nextInt(field.getColumns());

            minesPos[i] = new Position(row, column);
        }

        for (int i = 0; i < mines; i++) {
            field.placeTile(minesPos[i], true);
        }
    }
}
