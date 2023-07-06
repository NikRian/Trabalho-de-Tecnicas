package game.core.pieces.robots;

import game.core.board.Board;

public abstract class Robot {

    private char symbol;
    private int id, X, Y, points;
    private Board reference;

    public Robot(int id, char symbol, int X, int Y, Board board) {
        reference = board;
        this.symbol = symbol;
        this.id = id;
        this.X = --X;
        this.Y = --Y;
        this.points = 0;
    }

    public boolean isOk() {
		return 1 <= getX() && getX() <= reference.getQuantX() && 1 <= getY() && getY() <= reference.getQuantY();
	}

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }
}
