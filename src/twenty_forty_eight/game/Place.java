package src.twenty_forty_eight.game;

public class Place {
    private int row;
    private int column;

    public Place(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
