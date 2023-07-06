package game.core.board;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import game.core.pieces.entitys.*;
import game.core.pieces.robots.*;

public class Board {

    private int quantX, quantY, students, bugs;
    private Robot  walker, pawn, rook;

    private boolean gameOn;

    private List<Cell> cellsList = new ArrayList<>();
    private List<Robot> piecesList = new ArrayList<>();
    private List<Entity> studentsList = new ArrayList<>();
    private List<Entity> bugsList = new ArrayList<>();
    

    public Board() {

        this.gameOn = true;
        
        this.quantX = 8;
        this.quantY = 8;

        this.students = randomNumber(10, 20);
        this.bugs = randomNumber(5, 10);

        createCells();
        createEntities(students, bugs);
        createPieces();
    }

    private int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
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
            walker = new Walker(1, quantY,this),
            pawn = new Pawn(2, quantY,this),
            rook = new Rook(3, quantY,this),
        };
    }

    public int getQuantX() {
        return quantX;
    }

    public int getQuantY() {
        return quantY;
    }

    public List<Robot> getRobots() {
		return piecesList;
	}

    public Robot getRobo(int id) {
		for (Robot piece : getRobots()) {
			if (piece.getId() == id) {
				return piece;
			}
		}
		
		return null;
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

}