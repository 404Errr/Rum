package main;

import graphics.Window;
import set.Set;
import tile.Tile;

public class RumMain {
	public static void main(String[] args) {
		Game.init();
		
		Set set = new Set();
		set.add(new Tile(0,3));
		set.add(new Tile(1,3));
		set.add(new Tile(2,3));
		set.add(new Tile(3,3));
		set.sort();
		Game.allSets.add(set);
		Set set1 = new Set();
		set1.add(new Tile(1,1));
		set1.add(new Tile(1,2));
		set1.add(new Tile(1,5));
		set1.add(new Tile(1,4));
		set1.sort();
		Game.allSets.add(set1);
		
		Window.init();
		Thread update = new Thread(new UpdateLoop(), "UL");
		update.start();
		Game.run();
	}
}
