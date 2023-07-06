package game.core.pieces.robots;

import game.core.board.Board;

public class Walker extends Robot {
    public Walker(int x, int y, Board board) {
        super(3, 'P', x, y, board);
    }
}