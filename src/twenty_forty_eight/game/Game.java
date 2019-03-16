package src.twenty_forty_eight.game;

import java.util.List;

public class Game {
    Board board;

    public Game() {
        this.board = new Board();
    }

    public void startGame() {
        this.placeNumberInBoard();
        this.placeNumberInBoard();
        this.printBoard();
    }

    private int getRandomInteger(int limit) {
        return Math.round((float) Math.random() * limit);
    }

    public void placeNumberInBoard() {
        List<Place> emptyPlaces = List.copyOf(board.getEmptyPlaces());
        int index = this.getRandomInteger(emptyPlaces.size() - 1);
        if(!emptyPlaces.isEmpty()) {
            Place place = emptyPlaces.get(index);
            board.placeNumber(place, 2);
        }
    }

    public void printBoard() {
        board.printBoard();
    }

    public void moveNumbersToDown() {
        board.moveNumbersToDown();
    }
}
