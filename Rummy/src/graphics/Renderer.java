package graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.ColorData;
import data.GraphicsData;
import main.Game;
import tile.Tile;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements ColorData, GraphicsData {
	private static Graphics2D g;

	@Override
	public void paintComponent(Graphics g0) {
		g = (Graphics2D) g0;
		setBackground(COLOR_BACKGROUND);
		super.paintComponent(g);
		try {
			drawAllSets();
			drawHand(MARGIN, Window.height()-MARGIN*2, Game.players.get(0).getHand());
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.err.println(e.getMessage());
		}
	}
	
	private static void drawAllSets() {
		for (int set = 0;set<Game.allSets.size();set++) {
			for (int tile = 0;tile<Game.allSets.get(set).size();tile++) {
				drawTile(BOARD_ORIGIN_X+tile*(TILE_SIZE_X+TILE_GAP/*TODO add setgapx*/), BOARD_ORIGIN_Y+set*(TILE_SIZE_Y+SET_GAP_Y), TILE_SIZE_X, TILE_SIZE_Y, Game.allSets.get(set).get(tile).getColor(), Game.allSets.get(set).get(tile).getValue());
			}
		}
	}
	
	private static void drawTile(int x, int y, int sizeX, int sizeY, int color, int value) {
		g.setColor(ColorData.getColor(color));
		g.fillRect(x, y, sizeX, sizeY);
		g.setColor(COLOR_BLACK);
		if (color==BLACK) g.setColor(COLOR_WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, (int) (sizeX*0.6f)));
		g.drawString(value+"", x+((value>9)?sizeX/5:sizeX/3), y+sizeY*11/16);
	}

	private static void drawHand(int x, int y, ArrayList<Tile> hand) {
		for (int tile = 0;tile<hand.size();tile++) {
			drawTile(x+tile*(TILE_SIZE_X+TILE_GAP), y, TILE_SIZE_X, TILE_SIZE_Y, hand.get(tile).getColor(), hand.get(tile).getValue());
		}
	}
	
	public static Graphics2D getG() {
		return g;
	}
}
