package game.board;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import game.pieces.entitys.*;
import game.pieces.robots.*;

public class Board {

    private int quantX, quantY, limX, limY, students, bugs;
    private Robot  walker, pawn, rook, bishop, knight, king, queen;

    private List<Cell> cellsList = new ArrayList<>();
    private List<Robot> piecesList = new ArrayList<>();
    private List<Entity> studentsList = new ArrayList<>();
    private List<Entity> bugsList = new ArrayList<>();
    

    public Board(int x, int y, int students, int bugs) {
        
        this.quantX = x;
        this.quantY = y;
        this.limX = quantX * 10 + 1;
        this.limY = quantY * 4 + 1;

        this.students = students;
        this.bugs = bugs;

        createCells();
        createEntitys(students, bugs);
        createPieces();
    }

    private void createEntitys(int students, int bugs) {
        Set<Integer> ocupatedCells = new HashSet<>();
        Random random = new Random();
        int randomNumber = 0;
        int lim = (quantX)*(quantY*1/2)+1;

        System.out.println(lim);

        while (ocupatedCells.size() < bugs) {

           do {

                randomNumber = random.nextInt(lim);

            }  while(ocupatedCells.contains(randomNumber));

            ocupatedCells.add(randomNumber);

            Entity bug = new Bug(randomNumber);
            bugsList.add(bug);
            cellsList.get(randomNumber).addEntity(bug);
        }

        while (ocupatedCells.size() < bugs+students) {      

            do {
                randomNumber = random.nextInt(lim);

            }while(ocupatedCells.contains(randomNumber));

            ocupatedCells.add(randomNumber);

            Entity student = new Student(randomNumber);
            studentsList.add(student);
            cellsList.get(randomNumber).addEntity(student);
        }
    }
    
    private void createPieces() {
        Robot[] pieces = {
            new Walker(0, quantY),
            new Pawn(0, quantY),
            new Rook(0, quantY),
            new Bishop(0, quantY),
            new Knight(0, quantY),
            new King(0, quantY),
            new Queen(0, quantY)
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

    //#region gets of piecesList

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

    //#endregion

    public void walk(Robot piece, Board board, int moves) {

        int initialCell = ((piece.getY()*quantX)+piece.getX()),
        initialX = (initialCell%quantX),
        initialY = (initialCell/quantX),
        destiny = piece.move(initialX, initialY, moves, quantX, quantY);

        if (destiny == 0) {
            return;
        }

        board.clear();
        board.draw();
        board.delay(1);

        moves = Math.abs(moves);
        
        for(int aux = 0, auxB = 0; aux < moves; aux++, auxB += destiny) {

            if (aux != (moves)) {
                cellsList.get(initialCell-auxB).removePiece(piece);
            }
    
            cellsList.get(initialCell-auxB-destiny).addPiece(piece);
                
            board.clear();
            board.draw();
            board.delay(1);
        }
    }

    //#region drawing

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
                        System.out.print((char)27 + "[36m");
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
    //#endregion
}