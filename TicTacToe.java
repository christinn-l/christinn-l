package gameProject;

import java.util.Scanner;

public class TicTacToe {
    private final Board board;
    private final Player player1;
    private Player player2;
    private boolean isPlayer1Turn;

    public TicTacToe() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        isPlayer1Turn = true;
    }

    public void startGame() {
        board.printBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 or 2 Players?: ");
        int pickPlayer = scanner.nextInt();

        if (pickPlayer == 2) {
            while (!board.isFull() && !board.hasWinner()) {
                if (isPlayer1Turn) {
                    System.out.println(player1.getName() + "'s turn");
                    player1.makeMove(board);
                } else {
                    System.out.println(player2.getName() + "'s turn");
                    player2.makeMove(board);
                }
                board.printBoard();
                isPlayer1Turn = !isPlayer1Turn;
            }
        } else if (pickPlayer == 1) {
            while (!board.isFull() && !board.hasWinner()) {
                if (isPlayer1Turn) {
                    System.out.println(player1.getName() + "'s turn");
                    player1.makeMove(board);
                } else {
                    player2 = new CPU("CPU", 'O');
                    System.out.println(player2.getName() + "'s turn");
                    player2.makeMove(board);
                }
                board.printBoard();
                isPlayer1Turn = !isPlayer1Turn;
            }
        }
        else {
            System.out.println("Not valid number of players.");
        }
        if (board.hasWinner()) {
            System.out.println("Winner: " + (isPlayer1Turn ? player2.getName(): player1.getName()));
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();

        System.out.print("Good Game!");
    }
}

