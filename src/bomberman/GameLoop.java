package bomberman;

import javafx.animation.AnimationTimer;

public class GameLoop {

	private static double currentGameTime, oldGameTime, deltaTime, width, height;
	private final long startNanoTime = System.nanoTime();
	private boolean isStopped;
	private AnimationTimer animationT;
	private Sandbox sb;

	public GameLoop() {
		isStopped = true;
	};

	public GameLoop( Sandbox sandbox, double w, double h) {
		isStopped = true;
		init(sandbox, w, h);
	}

	public void init(Sandbox sandbox, double w, double h) {
		width = w;
		height = h;
		sb = sandbox;
		animationT = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				oldGameTime = currentGameTime;
				currentGameTime = (currentNanoTime - startNanoTime) / 1000000000.0;
				deltaTime = currentGameTime - oldGameTime;
				Renderer.gc.clearRect(0, 0, width, height);
				sb.update();
				renderGame(sb);
			}
		};
	}

	public static double getCurrentGameTime() {
		return currentGameTime;
	}

	public void start() {
		if (isStopped) {
			animationT.start();
			isStopped = false;
		}
	}

	public void stop() {
		if (!isStopped) {
			animationT.stop();
			isStopped = true;
		}
	}

	public double getDeltaTime() {
		return deltaTime * 100;
	}

	public static void renderGame(Sandbox sb) {
		sb.forEach(e -> e.draw(sb));
	}

}
