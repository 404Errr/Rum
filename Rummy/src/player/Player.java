package player;

import java.util.ArrayList;

import tile.Tile;

public class Player {
	private ArrayList<Tile> hand;
	private boolean AIControlled;
	
	public Player(boolean AIControlled) {
		hand = new ArrayList<>();
		this.AIControlled = AIControlled;
	}
}
