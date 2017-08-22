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
		Game.allSets.add(set);
		Window.init();
		Thread update = new Thread(new UpdateLoop(), "UL");
		System.out.println(set);
		update.start();
		Game.run();
	}
}
