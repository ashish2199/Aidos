package bomberman;

import bomberman.constants.GlobalConstants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bomberman extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(GlobalConstants.GAME_NAME + GlobalConstants.GAME_VERSION);
        GameHandler gh = new GameHandler();
        GameController controller = new GameController(gh);
        GameView view = new GameView(controller);
        gh.setView(view);
        controller.newGame();
        Scene s = view.getScene();
        primaryStage.setScene(s);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
