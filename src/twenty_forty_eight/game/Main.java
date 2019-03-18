package src.twenty_forty_eight.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.startGame();

        byte option;
        do {
            System.out.println("Choose your move :");
            System.out.println("1. Up");
            System.out.println("2. Down");
            System.out.println("3. Right");
            System.out.println("4. Left");
            System.out.println("5. Quit");
            option = scanner.nextByte();
            scanner.nextLine();
            takeAction(game, option);
        } while (option != 5);
    }

    private static void takeAction(Game game, byte option) {
        switch (option) {
            case 1:
                game.upMove();
                game.placeNumberInBoard();
                game.printBoard();
                break;
            case 2:
                game.downMove();
                game.placeNumberInBoard();
                game.printBoard();
                break;
            case 3:
                game.rightMove();
                game.placeNumberInBoard();
                game.printBoard();
                break;
            case 4:
                game.leftMove();
                game.placeNumberInBoard();
                game.printBoard();
                break;
        }
    }
}
