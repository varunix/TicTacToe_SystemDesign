package org.tictactoe.model;

public class Board {
    private int size;
    private Symbol[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new Symbol[size][size];
    }

    public void placeMove(Move move) {
        int row = move.getRow();
        int column = move.getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        this.cells[row][column] = symbol;
    }

    public boolean isCellEmpty(int row, int column) {
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
