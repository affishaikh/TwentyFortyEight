package src.twenty_forty_eight.game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        game.moveNumbersToDown();
        System.out.println("\n--------------------------\n");
        game.printBoard();
    }
}
