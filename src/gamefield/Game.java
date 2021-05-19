package gamefield;

public class Game {

    private Field field;
    private int mines;


    public Game(int rows, int columns, int mines) {
        this.field = new Field(rows, columns);
        this.mines = mines;
    }


    public Field getField() { return field; }
    public int getMines() { return mines; }

    public void generate() {


    }
}
