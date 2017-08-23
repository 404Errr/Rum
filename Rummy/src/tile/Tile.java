package tile;

public class Tile implements Comparable<Tile> {
	private int color, value;

	public Tile(int color, int value) {
		this.color = color;
		this.value = value;
	}

	public int getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Tile that) {
		if (this.value>that.value) return 1;
		if (this.value<that.value) return -1;
		if (this.color>that.color) return 1;
		if (this.color<that.color) return -1;
		return 0;
	}

	@Override
	public String toString() {
		return color+":"+value;
	}


}
