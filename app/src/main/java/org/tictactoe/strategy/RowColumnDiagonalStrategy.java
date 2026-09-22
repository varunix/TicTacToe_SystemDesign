package org.tictactoe.strategy;

import org.tictactoe.model.Board;
import org.tictactoe.model.Move;
import org.tictactoe.model.Symbol;

public class RowColumnDiagonalStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        return checkRow(board, move) || checkColumn(board, move) || checkDiagonals(board, move);
    }

    public boolean checkRow(Board board, Move move) {
        int row = move.getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        int sizeOfBoard = board.getBoardSize();
        for(int i=0; i<sizeOfBoard; i++) {
            if(board.getCell(row, i) != symbol) {
                return false;
            }
        }

        return true;
    }

    public boolean checkColumn(Board board, Move move) {
        int column = move.getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        int sizeOfBoard = board.getBoardSize();
        for(int i=0; i<sizeOfBoard; i++) {
            if(board.getCell(i, column) != symbol) {
                return false;
            }
        }

        return true;
    }

    public boolean checkDiagonals(Board board, Move move) {
        int row = move.getRow();
        int column = move.getColumn();
        int sizeOfBoard = board.getBoardSize();
        boolean mainDiagonalResponse = false;
        boolean antiDiagonalResponse = false;

        if(row == column && checkMainDiagonal(board, move)) {
             return true;
        }

        if(row+column == sizeOfBoard-1 && checkAntiDiagonal(board, move)) {
            return true;
        }

        return false;
    }

    public boolean checkMainDiagonal(Board board, Move move) {
        int sizeOfBoard = board.getBoardSize();
        Symbol symbol = move.getPlayer().getSymbol();
        for(int row=0; row<sizeOfBoard; row++) {
            int column = row;
            if(board.getCell(row, column) != symbol) {
                return false;
            }
        }

        return true;
    }

    public boolean checkAntiDiagonal(Board board, Move move) {
        int sizeOfBoard = board.getBoardSize();
        Symbol symbol = move.getPlayer().getSymbol();
        for(int row=0; row < sizeOfBoard; row++) {
            int column = sizeOfBoard-1-row;
            if(board.getCell(row, column) != symbol) return false;
        }

        return true;
    }
}