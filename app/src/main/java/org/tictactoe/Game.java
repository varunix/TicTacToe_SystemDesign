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
        if(this.gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Game is already over");
        }

        Move move = new Move(row, column, currentPlayer);
        this.board.placeMove(move);
        if(this.winningStrategy.checkWinner(this.board, move)) {
            this.winner = this.currentPlayer;
            this.gameStatus = GameStatus.WON;
        } else if(this.board.isFull()) {
            this.gameStatus = GameStatus.DRAW;
        } else {
            switchPlayer();
        }
    }

    private void switchPlayer() {
        int currentIndex = this.players.indexOf(currentPlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        currentPlayer = this.players.get(nextIndex);
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public Player getWinner() {
        return this.winner;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
}
