package gamefield;

public class Game {

    private Field field;
    private final int mines;


    public Game(int rows, int columns, int mines) {
        this.field = new Field(rows, columns);
        this.mines = mines;
    }


    public int getMines() { return mines; }

    public Tile[][] tiles() {

        return field.getTiles();
    }

    public void makeAction(String code) {

        Position pos = Position.valueOf(code);

        if (code.substring(5).equals("o")) {
            field.tile(pos).open();
        }
        else if (code.substring(5).equals("f")) {
            field.tile(pos).flag();
        }

    }

    public void generate() {


    }
}
