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
    public Tile[][] tiles() { return field.getTiles(); }

    public void makeAction(String code) { // input example: [A03 O]

        Position pos = Position.valueOf(code);
        char rule = code.charAt(4);

        switch (rule) {

            case 'O':
                field.tile(pos).open();
                if (field.tile(pos).isMine()) { gameOver = true; }
                if (field.tile(pos).toString().equals("0")) {
                    field.tile(pos).openSurroundingTiles();
                }
                break;

            case 'F':
                field.tile(pos).flag();
                break;

            default:

                break;
        }
    }

    public void generate(String code) { // input example: [A03 O]

        Position pos = Position.valueOf(code);
        Position[] clearPos = field.tile(pos).surroundingTiles();
        Position[] minesPos = new Position[mines];
        Random random = new Random();

        for (int i = 0; i < mines; i++) {

            int row, column;
            do {
                row = random.nextInt(field.getRows());
                column = random.nextInt(field.getColumns());

                minesPos[i] = new Position(row, column);
            }
            while (contains(clearPos, minesPos[i]));
        }

        for (int i = 0; i < mines; i++) {
            field.placeTile(minesPos[i], true);
        }
    }

    private static boolean contains(Position[] pos1, Position p2) {

        for (Position p1 : pos1) {

            if (p1 != null && p1 == p2) {
                return true;
            }
        }

        return false;
    }
}
