package gamefield;

public class Game {

    private Field field;
    private int mines;


    public Game(int rows, int columns, int mines) {
        this.field = new Field(rows, columns);
        this.mines = mines;
    }


    public int getMines() { return mines; }

    public Tile[][] field() {

        return field.getTiles();
    }

    public void generate() {


    }
}
