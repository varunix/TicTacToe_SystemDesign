package org.tictactoe;

import org.tictactoe.model.Board;
import org.tictactoe.model.GameStatus;
import org.tictactoe.model.Move;
import org.tictactoe.model.Player;
import org.tictactoe.strategy.WinningStrategy;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private WinningStrategy winningStrategy;
    private GameStatus gameStatus;
    private Player winner;

    public Game(Board board, List<Player> players, WinningStrategy winningStrategy) {
        if(players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Game must have at least one player");
        }
        this.board = board;
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.currentPlayer = players.get(0);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
    }

    public void makeMove(int row, int column) {
        Move move = new Move(row, column, currentPlayer);
        //TODO: Need to implement validation here
    }
}
