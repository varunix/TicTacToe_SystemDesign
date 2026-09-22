package org.tictactoe.strategy;

import org.tictactoe.model.Board;
import org.tictactoe.model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
