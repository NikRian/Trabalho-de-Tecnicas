package game;

import game.core.Player;
import game.core.board.Board;
import game.gui.*;

public class Game {

    private Board board = null;
    private mainFrame game;
    private Player player;
    private int rounds;
    
    public Game() {
        player = new Player("jhon");
        this.game = new mainFrame(this);
    }


    private void endGame() {
        //endgame
    }

    public void startGame() {
		player = new Player(game.getMainPane().getPlayerName());
		board = new Board();
		rounds = 0;

		game.changeGameMode();
	}

    public Board getBoard() {
        return board;
    }

    public int getBoardX() {
        return board.getQuantY();
    }

    public int getBoardY() {
        return board.getQuantY();
    }
}
