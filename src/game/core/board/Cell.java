package game.core.board;

import java.util.ArrayList;
import java.util.List;

import game.core.pieces.entitys.Entity;
import game.core.pieces.robots.Robot;

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