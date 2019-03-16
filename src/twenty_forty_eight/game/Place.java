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

    public Place getLowestNeighbour() {
        return new Place(3, this.column);
    }

    public Place getAboveNeighbour() {
        return new Place(this.row - 1, this.column);
    }
}
