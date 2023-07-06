package game.core.pieces.robots;

import game.core.board.Board;

public class Pawn extends Robot {
    public Pawn(int x, int y, Board board) {
        super(3, 'P', x, y, board);
    }
}
