package game.pieces.robots;

public class Rook extends Robot {
    public Rook(int x, int y) {
        super(4, 'T', x, y);
    }

    public int move(int initialX, int initialY, int moves, int limX, int limY) {

        int destinyY = initialY - moves;

        if (destinyY > limY || destinyY < 0 ||  Math.signum(moves) > 2) {
            System.out.println("Quantidade de movimentos inválida.");
            return 0;
        }

        this.setY(destinyY);

        return (int) Math.signum(moves) * (limX);
    }
}