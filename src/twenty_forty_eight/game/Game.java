package src.twenty_forty_eight.game;

import java.util.List;

class Game {
    private Board board;

    Game() {
        this.board = new Board();
    }

    void startGame() {
        performInitialMoves();
    }

    private void performInitialMoves() {
        this.placeNumberInBoard();
        this.placeNumberInBoard();
    }

    private int getRandomInteger(int limit) {
        return Math.round((float) Math.random() * limit);
    }

    void placeNumberInBoard() {
        List<Place> emptyPlaces = board.getEmptyPlaces();
        if (!emptyPlaces.isEmpty()) {
            int limit = emptyPlaces.size() - 1;
            int index = this.getRandomInteger(limit);
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
