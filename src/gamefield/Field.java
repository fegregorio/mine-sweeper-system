package gamefield;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final int rows;
    private final int columns;
    private Tile[][] tiles;


    public Field(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        tiles = new Tile[rows][columns];
        setClearField();
    }


    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public Tile[][] getTiles() { return tiles; }

    public Tile tile(Position pos) {
        if (!positionExists(pos)) {
            throw new GameException("Invalid position.");
        }
        return tiles[pos.row()][pos.column()];
    }

    public void placeTile(Position pos, boolean mine) {
        tiles[pos.row()][pos.column()] = new Tile(pos, mine, this);
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position pos) {
        return positionExists(pos.row(), pos.column());
    }

    public void setClearField() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tiles[i][j] = new Tile(new Position(i, j), false, this);
            }
        }
    }

    public Tile[] unsolvedZeroes() {

        List<Tile> zeroList = new ArrayList<>();

        for (Tile[] t : tiles) {
            for (Tile tile : t) {

                String icon = tile.toString();

                if (icon.equals("0") && !icon.equals(String.valueOf(tile.surroundingClosed()))) {

                    zeroList.add(tile);
                }
            }
        }

        Tile[] zeroes = new Tile[zeroList.size()];

        for (int i = 0; i < zeroList.size(); i++) {
            zeroes[i] = zeroList.get(i);
        }

        return zeroes;
    }
}
