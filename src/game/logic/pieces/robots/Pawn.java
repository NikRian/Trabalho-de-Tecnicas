package game.logic.pieces.robots;

public class Pawn extends Robot {
    public Pawn(int x, int y) {
        super(3, 'P', x, y);
    }

    public int move(int initialX, int initialY, int moves, int limX, int limY) {

        int destinyY = initialY - moves;

        if (destinyY > limY || destinyY < 0 || moves > 1  || moves < -1) {
            System.out.println("Quantidade de movimentos inválida");
            return 0;
        }

        this.setY(destinyY);

        return (moves > 0) ? limX : limX * (-1);
    }
}
