package graphics;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JFrame;

import data.GraphicsData;
import input.Input;

@SuppressWarnings("serial")
public class Window extends JFrame implements GraphicsData {
	private static JFrame frame;
	private static Input input;
	private static Renderer rendererer;

	public static void init() {
		rendererer = new Renderer();
		rendererer.setDoubleBuffered(true);
		input = new Input();
		frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());
		switch (WINDOW_FORMAT) {
		case BORDERLESS_FULLSCREEN:
			frame.setUndecorated(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			break;
		case WINDOWED_FULLSCREEN:
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		case WINDOWED:
			frame.setTitle("BG");
			GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			frame.setPreferredSize(new Dimension((int)(screen.getDisplayMode().getWidth()*DEFAULT_WINDOW_SCREEN_RATIO), (int)(screen.getDisplayMode().getHeight()*DEFAULT_WINDOW_SCREEN_RATIO)));
			frame.pack();
			frame.setLocationRelativeTo(null);
			break;
		}
		frame.addKeyListener(input);
		frame.addMouseMotionListener(input);
		frame.addMouseListener(input);
		frame.addMouseWheelListener(input);
		frame.addWindowListener(input);
		frame.addComponentListener(input);
		frame.add(rendererer);
		frame.setVisible(true);
		System.out.println("Window size: "+width()+","+height());
	}

	public static Renderer getRendererer() {
		return rendererer;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static int height() {
		return frame.getHeight();
	}

	public static int width() {
		return frame.getWidth();
	}

	public static int centerX() {
		return frame.getWidth()/2;
	}

	public static int centerY() {
		return frame.getHeight()/2;
	}
}
