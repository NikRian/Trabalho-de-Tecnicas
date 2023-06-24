package game.core.board;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import game.core.pieces.entitys.*;
import game.core.pieces.robots.*;

public class Board {

    private int quantX, quantY, limX, limY, students, bugs;
    private Robot  walker, pawn, rook, bishop, knight, king, queen;

    private boolean gameOn;

    private List<Cell> cellsList = new ArrayList<>();
    private List<Robot> piecesList = new ArrayList<>();
    private List<Entity> studentsList = new ArrayList<>();
    private List<Entity> bugsList = new ArrayList<>();
    

    public Board(int x, int y, int students, int bugs) {

        this.gameOn = true;
        
        this.quantX = x;
        this.quantY = y;
        this.limX = quantX * 10 + 1;
        this.limY = quantY * 4 + 1;

        this.students = students;
        this.bugs = bugs;

        createCells();
        createEntities(students, bugs);
        createPieces();
    }

    private void createEntities(int students, int bugs) {
        Set<Integer> occupiedCells = new HashSet<>();
        Random random = new Random();
        int randomNumber = 0;
        int lim = (quantX)*((quantY*1/2)+1);

        while (occupiedCells.size() < bugs) {

           do {

                randomNumber = random.nextInt(lim);

            }  while(occupiedCells.contains(randomNumber));

            occupiedCells.add(randomNumber);

            Entity bug = new Bug(randomNumber);
            bugsList.add(bug);
            cellsList.get(randomNumber).addEntity(bug);
        }

        while (occupiedCells.size() < bugs+students) {      

            do {
                randomNumber = random.nextInt(lim);

            }while(occupiedCells.contains(randomNumber));

            occupiedCells.add(randomNumber);

            Entity student = new Student(randomNumber);
            studentsList.add(student);
            cellsList.get(randomNumber).addEntity(student);
        }
    }
    
    private void createPieces() {
        Robot[] pieces = {
            walker = new Walker(1, quantY),
            pawn = new Pawn(2, quantY),
            rook = new Rook(3, quantY),
            bishop = new Bishop(4, quantY),
            knight = new Knight(5, quantY),
            king = new King(6, quantY),
            queen = new Queen(7, quantY)
        };
    
        for (Robot piece : pieces) {
            int cellIndex = (piece.getY() * quantX) + piece.getX();
            cellsList.get(cellIndex).addPiece(piece);
            piecesList.add(piece);
        }
    }

    private void createCells() {
        int id = 0;
        for (int auxY = 1; auxY <= quantY; auxY++) {
            for (int auxX = 1; auxX <= quantX; auxX++) {
                Cell cell = new Cell(id, auxX, auxY);
                cellsList.add(cell);
                id++;
            }
        }
    }

    public Robot getWalker() {
        return walker;
    }

    public Robot getPawn() {
        return pawn;
    }
    
    public Robot getBishop() {
        return bishop;
    }

    public Robot getRook() {
        return rook;
    }

    public Robot getKnight() {
        return knight;
    }

    public Robot getKing() {
        return king;
    }

    public Robot getQueen() {
        return queen;
    }

    public boolean getSituation() {
        return gameOn;
    }

    public void walk(Robot piece, Board board, int moves) {
        int initialCell = piece.getY() * quantX + piece.getX();
        int initialX = initialCell % quantX;
        int initialY = initialCell / quantX;
        int destiny = piece.move(initialX, initialY, moves, quantX, quantY);
    
        if (destiny == 0) {
            return;
        }
    
        board.clear();
        board.draw();
        board.delay(1);
    
        moves = Math.abs(moves);
        piece.changeState();
    
        for (int aux = 0, auxB = 0; aux < moves; aux++, auxB += destiny) {
            if (aux != moves) {
                cellsList.get(initialCell - auxB).removePiece(piece);
            }
    
            if (aux == moves - 1) {
                piece.changeState();
            }
    
            cellsList.get(initialCell - auxB - destiny).addPiece(piece);
    
            board.clear();
            board.draw();
            board.delay(1);
        }

        int atualCell = piece.getY() * quantX + piece.getX();

        if(cellsList.get(atualCell).hasEntity()) {
            studentsList.remove(studentsList.size()-1);
        }

        if(studentsList.isEmpty()) {
            this.gameOn = false;
        }
        
    }

    public void draw() {
        for (int y = 1; y <= limY; y++) {
            for (int x = 1; x <= limX; x++) {
                if (y == 1) {
                    printRow(x, "┌", "┬", "┐", "─");
                } else if (y == limY) {
                    printRow(x, "└", "┴", "┘", "─");
                } else {
                    printMiddleRow(x, y);
                }
            }
            System.out.println();
        }
    }

    private void printRow(int x, String left, String middle, String right, String horizontal) {
        if (x == 1) {
            System.out.print(left);
        } else if (x == limX) {
            System.out.print(right);
        } else if ((x - 1) % 10 == 0) {
            System.out.print(middle);
        } else {
            System.out.print(horizontal);
        }
    }

    private void printMiddleRow(int x, int y) {
        if ((y - 1) % 4 != 0) {
            if (x == 1 ) {
                System.out.print("│");
            } else if ( x == limX || (x - 1) % 10 == 0) {
                System.out.print("│");
            }else if ((x - 1) % 5 == 0 && (y + 1) % 4 == 0) {

                int cellX = x / 10 + 1;
                int cellY = y / 4 + 1;

                for (Cell cell : cellsList) {
                    if (cell.getPositionX() == cellX && cell.getPositionY() == cellY) {

                        if(cell.hasRobot()) {
                            System.out.print((char)27 + "[36m");
                        } else if (cell.hasEntity()) {
                            if(cell.getSymbol() == '■') {
                                System.out.print((char)27 + "[32m");
                            } else {
                                System.out.print((char)27 + "[31m");
                            }
                        }
                        
                        System.out.print(cell.getSymbol());
                        System.out.print((char)27 + "[39m");
                    }
                }
            } else {
                System.out.print(" ");
            }
        } else {
            printRow(x, "├", "┼", "┤", "─");
        }
    }

    private void delay(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}