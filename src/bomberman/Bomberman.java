package bomberman;

import bomberman.constants.GlobalConstants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Bomberman extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(GlobalConstants.GAME_NAME + GlobalConstants.GAME_VERSION);
        GameHandler gh = new GameHandler();
        Scene s = gh.getScene();
        BorderPane b = gh.getBorderPane();
        primaryStage.setScene(s);
        primaryStage.minWidthProperty().bind(b.widthProperty());
        primaryStage.minHeightProperty().bind(b.heightProperty());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
