package data;

public interface GraphicsData {
//	WindowType WINDOW_FORMAT = WindowType.WINDOWED;
	WindowType WINDOW_FORMAT = WindowType.WINDOWED_FULLSCREEN;
//	WindowType WINDOW_FORMAT = WindowType.BORDERLESS_FULLSCREEN;
	enum WindowType {
		BORDERLESS_FULLSCREEN, WINDOWED_FULLSCREEN, WINDOWED
	}

	float DEFAULT_SCALE_RATIO = 0.035f;
	float DEFAULT_WINDOW_SCREEN_RATIO = 0.8f;

	int MARGIN = 50;
	int BOARD_ORIGIN_X = MARGIN*3/2, BOARD_ORIGIN_Y = MARGIN*4;
	int TILE_SIZE_X = 30, TILE_SIZE_Y = 40;
	int TILE_GAP = (int) (TILE_SIZE_X*0.15f);
	int SET_GAP_X = TILE_SIZE_X*1/2, SET_GAP_Y = TILE_SIZE_X*1/2;
}
