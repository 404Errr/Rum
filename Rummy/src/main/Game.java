package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import data.GameData;
import player.Player;
import set.Set;
import tile.Tile;

public class Game implements GameData {
	public static ArrayList<Set> allSets;
	public static ArrayList<Player> players;
	public static Stack<Tile> deck;
	
	public static void init() {
		allSets = new ArrayList<>();
		players = new ArrayList<>();
		players.add(new Player(false));
		players.add(new Player(true));
		
		deck = new Stack<>();
		for (int twice = 0;twice<2;twice++) {
			for (int c = 0;c<4;c++) {
				for (int v = 1;v<=13;v++) {
					deck.add(new Tile(c, v));
				}
			}
		}
		Collections.shuffle(deck);
		for (int p = 0;p<players.size();p++) {
			for (int t = 0;t<INITIAL_TILE_COUNT;t++) {
				players.get(p).giveTile(deck.pop());
			}
			Collections.sort(players.get(p).getHand());
		}
	}

	public static void run() {
		int turn = -1;
		while (!someoneOut()) {
			turn++;
			if (turn>players.size()) turn = 0;
			
			
		}
	}
	
	private static boolean someoneOut() {
		for (int p = 0;p<players.size();p++) {
			if (players.get(p).getHand().isEmpty()) return true;
		}
		return false;
	}
}
