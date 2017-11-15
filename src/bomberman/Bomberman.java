package bomberman;

import static bomberman.constants.GlobalConstants.*;
import bomberman.scenes.Sandbox;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Bomberman extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(GAME_NAME + GAME_VERSION);
        Scene s = Sandbox.getScene();
        
        
        primaryStage.setScene(s);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
