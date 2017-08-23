package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import data.ColorData;
import data.GraphicsData;
import main.Game;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements ColorData, GraphicsData {
	private static Graphics2D g;

	@Override
	public void paintComponent(Graphics g0) {
		g = (Graphics2D) g0;
		setBackground(COLOR_BACKGROUND);
		super.paintComponent(g);
		try {
			for (int set = 0;set<Game.allSets.size();set++) {
				for (int tile = 0;tile<Game.allSets.get(set).size();tile++) {
					drawTile(BOARD_ORIGIN_X+tile*(TILE_SIZE_X+TILE_GAP)+MARGIN, BOARD_ORIGIN_Y+set*(TILE_SIZE_Y+SET_GAP_Y/*TODO add x*/)+MARGIN, TILE_SIZE_X, TILE_SIZE_Y, Game.allSets.get(set).get(tile).getColor(), Game.allSets.get(set).get(tile).getValue());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.err.println(e.getMessage());
		}
	}
	
	private static void drawTile(int x, int y, int sizeX, int sizeY, int color, int value) {
		g.setColor(ColorData.getColor(color));
		g.fillRect(x, y, sizeX, sizeY);
		g.setColor(COLOR_BLACK);
		if (color==BLACK) g.setColor(COLOR_WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, sizeX));
		g.drawString(value+"", x+sizeX/4, y+sizeY*3/4);
	}

	public static Graphics2D getG() {
		return g;
	}
}
