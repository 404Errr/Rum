package main;

import java.util.ArrayList;
import java.util.Collections;

import player.Player;
import set.Set;
import tile.Tile;

public class Game {
	public static ArrayList<Set> allSets;
	public static ArrayList<Player> players;
	public static ArrayList<Tile> deck;
	
	public static void init() {
		allSets = new ArrayList<>();
		players = new ArrayList<>();
		players.add(new Player(false));
		players.add(new Player(true));
		
		deck = new ArrayList<>();
		for (int twice = 0;twice<2;twice++) {
			for (int c = 0;c<4;c++) {
				for (int v = 1;v<=13;v++) {
					deck.add(new Tile(c, v));
				}
			}
		}
		Collections.shuffle(deck);
		
		System.out.println(deck);
	}

	public static void run() {

	}
}
