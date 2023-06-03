package game.pieces.entitys;

public abstract class Entity {

    private int X, Y, id, points, type;
    private char symbol;

    public Entity(int id, int points, char symbol, int type) {

        this.id = id;
        this.symbol = symbol;
        this.X = id;
        this.Y = id;
        this.points = points;
        this.type = type;
    }

    public int getType() {
        return type;
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
