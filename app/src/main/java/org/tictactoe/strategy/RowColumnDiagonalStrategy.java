package org.tictactoe.strategy;

import org.tictactoe.model.Board;
import org.tictactoe.model.Move;
import org.tictactoe.model.Symbol;

public class RowColumnDiagonalStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        return checkRow(board, move) || checkColumn(board, move) || checkDiagonal(board, move);
    }

    public boolean checkRow(Board board, Move move) {
        int row = move.getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        for(int i=0; i<board.getBoardSize(); i++) {
            if(board.getCell(row, i) != symbol) {
                return false;
            }
        }

        return true;
    }

    public boolean checkColumn(Board board, Move move) {
        int column = move.getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        for(int i=0; i<board.getBoardSize(); i++) {
            if(board.getCell(i, column) != symbol) {
                return false;
            }
        }

        return true;
    }

    public boolean checkDiagonal(Board board, Move move) {
        int row = move.getRow();
        int column = move.getColumn();

        if(row == column && checkMainDiagonal(board, move)) {
             return true;
        }

        if(row+column == board.getBoardSize()-1 && checkAntiDiagonal(board, move)) {
            return true;
        }

        return false;
    }

    public boolean checkMainDiagonal(Board board, Move move) {
        Symbol symbol = move.getPlayer().getSymbol();
        for(int row=0; row<board.getBoardSize(); row++) {
            int column = row;
            if(board.getCell(row, column) != symbol) {
                return false;
            }
        }

        return true;
    }

    public boolean checkAntiDiagonal(Board board, Move move) {
        Symbol symbol = move.getPlayer().getSymbol();
        for(int row=0; row < board.getBoardSize(); row++) {
            int column = board.getBoardSize()-1-row;
            if(board.getCell(row, column) != symbol) return false;
        }

        return true;
    }
}