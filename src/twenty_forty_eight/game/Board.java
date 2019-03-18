package src.twenty_forty_eight.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {
    private int[][] board;
    List<Place> places;

    Board() {
        board = new int[4][4];
        this.initializePlaces();
    }

    private void initializePlaces() {
        List<Place> places = new ArrayList<>();
        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board.length; column++) {
                Place place = new Place(row, column);
                places.add(place);
            }
        }

        this.places = List.copyOf(places);
    }

    private boolean isEmpty(Place place) {
        int row = place.getRow();
        int column = place.getColumn();
        return this.board[row][column] == 0;
    }

    public List getEmptyPlaces() {
        List<Place> emptyPlaces = new ArrayList<>();
        Iterator<Place> iterator = this.places.iterator();

        while (iterator.hasNext()) {
            Place place = iterator.next();
            if (isEmpty(place)) {
                emptyPlaces.add(place);
            }
        }

        return List.copyOf(emptyPlaces);
    }

    public void placeNumber(Place place) {
        int row = place.getRow();
        int column = place.getColumn();
        this.board[row][column] = 2;
    }

    public void printBoard() {
        for (int row = 0; row < this.board.length; row++) {
            System.out.println(" _ _ _ _ _ _ _ _ _ _");
            System.out.print("|");
            for (int column = 0; column < this.board.length; column++) {
                if (this.board[row][column] == 0) {
                    System.out.print("    |");
                } else {
                    System.out.print(this.board[row][column] + "   |");
                }
            }
            System.out.println();
        }
        System.out.println(" _ _ _ _ _ _ _ _ _ _");
    }

    public void downMove() {
        int[] columns = new int[]{0, 1, 2, 3};
        for (int column : columns) {
            moveNumbersDown(column);
            addNumbersInDownDirection(column);
            moveNumbersDown(column);
        }
    }

    public void upMove() {
        int[] columns = new int[]{0, 1, 2, 3};
        for (int column : columns) {
            moveNumbersUp(column);
            addNumbersInUpDirection(column);
            moveNumbersUp(column);
        }
    }

    public void rightMove() {
        int[] columns = new int[]{0, 1, 2, 3};
        transpose();
        for (int column : columns) {
            moveNumbersDown(column);
            addNumbersInDownDirection(column);
            moveNumbersDown(column);
        }
        transpose();
    }

    public void leftMove() {
        int[] columns = new int[]{0, 1, 2, 3};
        transpose();
        for (int column : columns) {
            moveNumbersUp(column);
            addNumbersInUpDirection(column);
            moveNumbersUp(column);
        }
        transpose();
    }

    private void moveNumbersUp(int column) {
        for (int row = 1; row <= 3; row++) {
            for (int row1 = row; row1 >= 1; row1--) {
                if (this.board[row1 - 1][column] == 0) {
                    this.board[row1 - 1][column] = this.board[row1][column];
                    this.board[row1][column] = 0;
                }
            }
        }
    }

    private void moveNumbersDown(int column) {
        for (int row = 2; row >= 0; row--) {
            for (int row1 = row; row1 <= 2; row1++) {
                if (this.board[row1 + 1][column] == 0) {
                    this.board[row1 + 1][column] = this.board[row1][column];
                    this.board[row1][column] = 0;
                }
            }
        }
    }

    private void addNumbersInDownDirection(int column) {
        for (int row = 2; row >= 0; row--) {
            int aboveNumber = this.board[row][column];
            int belowNumber = this.board[row + 1][column];
            if (aboveNumber == belowNumber && aboveNumber > 0) {
                this.board[row + 1][column] += this.board[row][column];
                this.board[row][column] = 0;
            }
        }
    }

    private void addNumbersInUpDirection(int column) {
        for (int row = 0; row < 3; row++) {
            int aboveNumber = this.board[row][column];
            int belowNumber = this.board[row + 1][column];
            if (aboveNumber == belowNumber && aboveNumber > 0) {
                this.board[row][column] += this.board[row + 1][column];
                this.board[row + 1][column] = 0;
            }
        }
    }

    private void transpose() {
        int[][] transpose = new int[4][4];

        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board.length; column++) {
                transpose[row][column] = this.board[column][row];
            }
        }
        this.board = transpose;
    }
}
