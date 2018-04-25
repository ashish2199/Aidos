package bomberman;

public interface GameObserver {
	void newLevel(double width, double height);
	void update();
}
