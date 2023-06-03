package game.board;

import java.util.ArrayList;
import java.util.List;

import game.pieces.entitys.Entity;
import game.pieces.robots.Robot;

public class Cell {

    private int id, positionX, positionY;
	private char symbol;
	private boolean hasRobot, hasEntity;
	private List<Robot> pieces;
	private Entity entity;

	public Cell(int id, int x , int y) {
		this.id = id;
		this.positionX = x;
		this.positionY = y;
		this.symbol = ' ';
		this.hasRobot = false;
		this.hasEntity = false;
		this.entity = null;
		this.pieces = new ArrayList<>();
	}

	public boolean hasRobot() {
		return hasRobot;
	}

	public boolean hasEntity() {
		return hasEntity;
	}

	public int getId() {
		return id;
	}

	public void addEntity(Entity entity) {
		this.hasEntity = true;
		this.entity = entity;
		this.symbol = entity.getSymbol();
    }

	public void addPiece(Robot piece) {
        pieces.add(piece);
		this.hasRobot = true;

		if(pieces.size() == 1) {
			this.symbol = piece.getSymbol();
		} else {
			this.symbol = '@';
		}

		if(!hasEntity || piece.getState()) {
			return;
		}

		if(entity.getType() == 1) {
			piece.addPoints(entity.getPoints());
		} else {
			piece.addPoints(entity.getPoints());
			this.entity = null;
			this.hasEntity = false;
		}
		
    }

	public void removePiece(Robot piece) {
		pieces.remove(piece);
		
		if (pieces.isEmpty()) {

			this.hasRobot = false;
			this.symbol = ' ';
			
			if (hasEntity) {
				this.symbol = entity.getSymbol();
			}
			
		} else {
			this.symbol = pieces.get(pieces.size()-1).getSymbol();
		}
	}

	public List<Robot> getPieces() {
		return pieces;
	}

	public char getSymbol() {
		return symbol;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public String toString() {
		return "id: "+id + " || x:"+positionX+" y: "+positionY+"\n";
	}
}