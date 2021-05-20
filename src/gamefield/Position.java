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

    protected String asCode(Position pos) {
        return String.format("%s %02d", (char) ('A' + column), row + 1);
    }

    protected static Position valueOf(String code) { // input example: [A03 O]
        return new Position(Integer.parseInt(code.substring(1, 3)) - 1, (code.charAt(0)) - 'A');
    }

    @Override
    public String toString() {
        return String.format("%d, %d", row, column);
    }
}
