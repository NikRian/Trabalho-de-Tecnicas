package game.core;

public class Player {
	
	private String name;

	private int points;
	
	public Player(String name) {
		this.name = name;
	}
    
	public String getNome() {
		return name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
}
