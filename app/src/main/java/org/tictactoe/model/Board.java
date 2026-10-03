package org.tictactoe.model;

import org.tictactoe.strategy.RowColumnDiagonalStrategy;
import org.tictactoe.strategy.WinningStrategy;

public class Board {
    private int size;
    private Symbol[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new Symbol[size][size];
    }

    public void placeMove(Move move) {
        if(!isMoveValid(move)) {
            throw new IllegalArgumentException("Invalid move. Please try again!");
        }
        int row = move.getRow();
        int column = move.getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        this.cells[row][column] = symbol;
    }

    private boolean isMoveValid(Move move) {
        int row = move.getRow();
        int column = move.getColumn();

        if((row >= this.size || column >= this.size) || row < 0 || column < 0 || isFull() || !isCellEmpty(row, column)) {
            return false;
        }

        return true;
    }

    private boolean isCellEmpty(int row, int column) {
        return cells[row][column] == null;
    }

    public boolean isFull() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(cells[i][j] == null) return false;
            }
        }

        return true;
    }

    public int getBoardSize() {
        return this.size;
    }

    public Symbol getCell(int row, int column) {
        return this.cells[row][column];
    }
}
