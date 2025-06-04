package gameProject;

import java.util.Random;

public class CPU extends Player {
    public CPU(String name, char symbol) {
        super(name, symbol);
    }
    @Override
    public void makeMove(Board board) {
        Random rand = new Random();
        int row, col;
        while (true) {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
            if (board.makeMove(row, col, getSymbol())) {
                System.out.println("CPU (" + getSymbol() + ") chooses: " + row + "," + col);
                break;
            }
        }
    }
}

