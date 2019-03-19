package src.twenty_forty_eight.game;

import java.util.List;

class Game {
    private Board board;

    Game() {
        this.board = new Board();
    }

    void startGame() {
        this.placeNumberInBoard();
        this.placeNumberInBoard();
        this.printBoard();
    }

    private int getRandomInteger(int limit) {
        return Math.round((float) Math.random() * limit);
    }

    void placeNumberInBoard() {
        List<Place> emptyPlaces = List.copyOf(board.getEmptyPlaces());
        int index = this.getRandomInteger(emptyPlaces.size() - 1);
        if (!emptyPlaces.isEmpty()) {
            Place place = emptyPlaces.get(index);
            board.placeNumber(place);
        }
    }

    void printBoard() {
        board.printBoard();
    }

    void downMove() {
        board.downMove();
    }

    void upMove() {
        board.upMove();
    }

    void rightMove() {
        board.rightMove();
    }

    void leftMove() {
        board.leftMove();
    }
}
