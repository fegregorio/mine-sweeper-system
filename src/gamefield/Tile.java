package gamefield;

public class Tile {

    private final Position pos;
    private static Field field;
    private final boolean mine;
    private boolean open;
    private boolean flag;


    public Tile(Position pos, boolean mine, Field field) {
        this.pos = pos;
        Tile.field = field;
        this.mine = mine;
        open = false;
        flag = false;
    }


    public Position getPos() { return pos; }
    public boolean isMine() { return mine; }
    public boolean isOpen() { return open; }
    public boolean isFlag() { return flag; }

    public void open() {
        if (!flag) { open = true; }
    }
    public void flag() {
        if (!open) { flag = !flag; }
    }

    @Override
    public String toString() {

        if (open) {
            if (!mine) { return String.valueOf(surroundingMines()); }
            else { return "M"; }
        }
        else {
            if (flag) { return "F"; }
            else { return "•"; }
        }
    }

    public int surroundingMines() {

        int amount = 0;
        Position p = new Position(0, 0);

        p.setValues(pos.row() - 1, pos.column());
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        p.setValues(pos.row() - 1, pos.column() - 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        p.setValues(pos.row(), pos.column() - 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column() - 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column());
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column() + 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        p.setValues(pos.row(), pos.column() + 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        p.setValues(pos.row() - 1, pos.column() + 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isMine()) { amount++; }
        }

        return amount;
    }

    public int surroundingFlags() {

        int amount = 0;
        Position p = new Position(0, 0);

        p.setValues(pos.row() - 1, pos.column());
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        p.setValues(pos.row() - 1, pos.column() - 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        p.setValues(pos.row(), pos.column() - 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column() - 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column());
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column() + 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        p.setValues(pos.row(), pos.column() + 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        p.setValues(pos.row() - 1, pos.column() + 1);
        if (field.positionExists(p)) {
            if (field.tile(p).isFlag()) { amount++; }
        }

        return amount;
    }

    public int surroundingClosed() {

        int amount = 0;
        Position p = new Position(0, 0);

        p.setValues(pos.row() - 1, pos.column());
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        p.setValues(pos.row() - 1, pos.column() - 1);
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        p.setValues(pos.row(), pos.column() - 1);
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column() - 1);
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column());
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        p.setValues(pos.row() + 1, pos.column() + 1);
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        p.setValues(pos.row(), pos.column() + 1);
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        p.setValues(pos.row() - 1, pos.column() + 1);
        if (field.positionExists(p)) {
            if (!field.tile(p).isOpen()) { amount++; }
        }

        return amount;
    }

    public void openSurroundingTiles() {

        int amount = 0;
        Position p = new Position(0, 0);

        p.setValues(pos.row() - 1, pos.column());
        if (field.positionExists(p)) {
            field.tile(p).open();
        }

        p.setValues(pos.row() - 1, pos.column() - 1);
        if (field.positionExists(p)) {
            field.tile(p).open();
        }

        p.setValues(pos.row(), pos.column() - 1);
        if (field.positionExists(p)) {
            field.tile(p).open();
        }

        p.setValues(pos.row() + 1, pos.column() - 1);
        if (field.positionExists(p)) {
            field.tile(p).open();
        }

        p.setValues(pos.row() + 1, pos.column());
        if (field.positionExists(p)) {
            field.tile(p).open();
        }

        p.setValues(pos.row() + 1, pos.column() + 1);
        if (field.positionExists(p)) {
            field.tile(p).open();
        }

        p.setValues(pos.row(), pos.column() + 1);
        if (field.positionExists(p)) {
            field.tile(p).open();
        }

        p.setValues(pos.row() - 1, pos.column() + 1);
        if (field.positionExists(p)) {
            field.tile(p).open();
        }
    }

    public Position[] surroundingTiles() {

        Position[] clearTiles = new Position[9];
        Position p = new Position(0, 0);

        p.setValues(pos.row() - 1, pos.column());
        if (field.positionExists(p)) {
            clearTiles[0] = new Position(p.row(), p.column());
        }

        p.setValues(pos.row() - 1, pos.column() - 1);
        if (field.positionExists(p)) {
            clearTiles[1] = new Position(p.row(), p.column());
        }

        p.setValues(pos.row(), pos.column() - 1);
        if (field.positionExists(p)) {
            clearTiles[2] = new Position(p.row(), p.column());
        }

        p.setValues(pos.row() + 1, pos.column() - 1);
        if (field.positionExists(p)) {
            clearTiles[3] = new Position(p.row(), p.column());
        }

        p.setValues(pos.row() + 1, pos.column());
        if (field.positionExists(p)) {
            clearTiles[4] = new Position(p.row(), p.column());
        }

        p.setValues(pos.row() + 1, pos.column() + 1);
        if (field.positionExists(p)) {
            clearTiles[5] = new Position(p.row(), p.column());
        }

        p.setValues(pos.row(), pos.column() + 1);
        if (field.positionExists(p)) {
            clearTiles[6] = new Position(p.row(), p.column());
        }

        p.setValues(pos.row() - 1, pos.column() + 1);
        if (field.positionExists(p)) {
            clearTiles[7] = new Position(p.row(), p.column());
        }

        clearTiles[8] = new Position(pos.row(), pos.column());

        return clearTiles;
    }
}
