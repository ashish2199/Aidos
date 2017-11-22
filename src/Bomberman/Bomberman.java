package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.scenes.Sandbox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bomberman extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(GlobalConstants.GAME_NAME + GlobalConstants.GAME_VERSION);
        Sandbox.setupScene();
        Scene s = Sandbox.getScene();
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
