package gamefield;

public class Tile {

    private Position pos;
    private static Field field;
    private boolean mine;
    private boolean open;
    private boolean flag;


    public Tile(Position pos, boolean mine, Field field) {
        this.pos = pos;
        this.mine = mine;
        open = false;
        flag = false;
    }


    public Position getPos() { return pos; }
    public boolean isMine() { return mine; }
    public boolean isOpen() { return open; }
    public boolean isFlag() { return flag; }

    public void open() { open = true; }
    public void flag() {
        if (!open) { flag = !flag; }
        // else { throw new GameException("This tile cannot have a flag."); }
    }

    @Override
    public String toString() {

        if (open) {
            if (!mine) { return String.valueOf(surroundingMines()); }
        }
        else {
            if (flag) { return "F"; }
            else { return "•"; }
        }

        return "?";
    }

    public int surroundingMines() {

        int amount = 0;
        Position p = new Position(0, 0);

        p.setValues(pos.row() - 1, pos.column());
        if (field.tile(p).isMine()) { amount++; }

        p.setValues(pos.row() - 1, pos.column() - 1);
        if (field.tile(p).isMine()) { amount++; }

        p.setValues(pos.row(), pos.column() - 1);
        if (field.tile(p).isMine()) { amount++; }

        p.setValues(pos.row() + 1, pos.column() - 1);
        if (field.tile(p).isMine()) { amount++; }

        p.setValues(pos.row() + 1, pos.column());
        if (field.tile(p).isMine()) { amount++; }

        p.setValues(pos.row() + 1, pos.column() + 1);
        if (field.tile(p).isMine()) { amount++; }

        p.setValues(pos.row(), pos.column() + 1);
        if (field.tile(p).isMine()) { amount++; }

        p.setValues(pos.row() - 1, pos.column() + 1);
        if (field.tile(p).isMine()) { amount++; }

        return amount;
    }
}
