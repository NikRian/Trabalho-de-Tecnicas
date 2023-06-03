package game.pieces.robots;

public abstract class Robot {

    private char symbol;
    private boolean walking;
    private int id, X, Y, points;

    public Robot(int id, char symbol, int X, int Y) {
        this.symbol = symbol;
        this.walking = false;
        this.id = id;
        this.X = --X;
        this.Y = --Y;
        this.points = 0;
    }

    public int move (int initialX, int initialY, int moves, int limX, int limY) {

        int destiny = 0;

        this.move(initialX, initialY, moves, limX, limY);

        return destiny;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public boolean getState() {
        return walking;
    }

    public void changeState() {
        this.walking = !this.walking;
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
