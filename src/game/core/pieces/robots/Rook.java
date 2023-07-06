package game.core.pieces.robots;

import game.core.board.Board;

public class Rook extends Robot {
    public Rook(int x, int y, Board board) {
        super(3, 'P', x, y, board);
    }
}