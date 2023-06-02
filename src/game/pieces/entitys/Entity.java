package game.pieces.entitys;

public abstract class Entity {

    private int X, Y, id, points;
    private char symbol;

    public Entity(int id, int points, char symbol) {

        this.id = id;
        this.symbol = symbol;
        this.X = id;
        this.Y = id;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public char getSymbol() {
        return symbol;
    }

    public String toString() {
        return "id: "+id+" - ("+X+", "+Y+")";
    }
}
