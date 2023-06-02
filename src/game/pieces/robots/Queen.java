package game.pieces.robots;

public class Queen extends Robot {
    public Queen(int x, int y) {
        super(3, 'Q', x, y);
    }

    public int move(int initialX, int initialY, int moves, int limX, int limY) {

        int destinyX = initialX + moves,
            destinyY = initialY - moves;

        if (destinyX > limX || destinyX < 0 || destinyY < 0 ||destinyY > limY || Math.signum(moves) > 4) {
            System.out.println("out of bounds");
            return 0;
        }

        this.setX(destinyX);
        this.setY(destinyY);

        return (int) Math.signum(moves) * (limX - 1) ;
    }
}
