package data;

import java.awt.Color;

public interface ColorData {
	Color COLOR_ERROR = new Color(0x940e94);//magenta
	Color COLOR_BACKGROUND = new Color(0xf0f0f0);//background color
	
	Color COLOR_BLACK = new Color(0x000000);
	Color COLOR_WHITE = new Color(0xffffff);
	
	int BLACK = 0, BLUE = 1, RED = 2, ORANGE = 3;
	
	static Color getColor(int color) {
		switch (color) {
		case BLACK: return new Color(0x000000);
		case BLUE: return new Color(0x5050ff);
		case RED: return new Color(0xff5050);
		case ORANGE: return new Color(0xffa500);
		}
		return null;
	}
}
