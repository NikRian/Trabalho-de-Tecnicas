package game.pieces.robots;

public abstract class Robot {

    private char symbol;
    private int id, X, Y;

    public Robot(int id, char symbol, int X, int Y) {
        this.symbol = symbol;
        this.id = id;
        this.X = --X;
        this.Y = --Y;
    }

    public int move (int initialX, int initialY, int moves, int limX, int limY) {

        int destiny = 0;

        this.move(initialX, initialY, moves, limX, limY);

        /*if (this instanceof Walker) {
           destiny =  ((Walker) this).move(initialX, initialY, moves, limX, limY);
        } else if (this instanceof Pawn) {
            destiny =  ((Pawn) this).move(initialX, initialY, moves, limX, limY);
        } else if (this instanceof Rook) {
            destiny =  ((Rook) this).move(initialX, initialY, moves, limX, limY);
        } else if (this instanceof Bishop) {
            destiny =  ((Bishop) this).move(initialX, initialY, moves, limX, limY);
        } else if (this instanceof Knight) {
            destiny =  ((Knight) this).move(initialX, initialY, moves, limX, limY);
        } else if (this instanceof King) {
            destiny =  ((King) this).move(initialX, initialY, moves, limX, limY);
        } else if (this instanceof Queen) {
            destiny =  ((Queen) this).move(initialX, initialY, moves, limX, limY);
        }*/

        return destiny;
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
