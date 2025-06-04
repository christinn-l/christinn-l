package gameProject;
import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
    @Override
    public String toString() {
        return "Player: " + name + ", Symbol: " + symbol;
    }
    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Enter row (0-2) and column (0-2) for " + name + "'s move:");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (board.makeMove(row, col, symbol)) {
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }


}
