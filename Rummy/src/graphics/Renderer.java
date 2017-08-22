package graphics;

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
					drawTile(tile*(TILE_SIZE_X+MARGIN)+MARGIN, set*(TILE_SIZE_Y+MARGIN)+MARGIN, TILE_SIZE_X, TILE_SIZE_Y, Game.allSets.get(set).get(tile).getColor(), Game.allSets.get(set).get(tile).getValue());
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
	}

	public static Graphics2D getG() {
		return g;
	}
}
