package gamefield;

public class Position {

    private int row;
    private int column;


    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }


    public int row() { return row; }
    public int column() { return column; }

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("%d, %d", row, column);
    }
}
