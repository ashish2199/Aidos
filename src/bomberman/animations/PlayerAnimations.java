/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.animations;

import bomberman.utils.ImageUtils;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static bomberman.constants.GlobalConstants.*;

/**
 * @author Ashish
 */
public class PlayerAnimations {

    static Image img;

    public static void init() {
        img = ImageUtils.loadImage("src/Resources/img/sprites.png");
    }


    public static void walkDownAnimation(GraphicsContext gc) {
        init();


        final Timeline timeline1 = new Timeline();
        timeline1.setCycleCount(1);
        //timeline1.setAutoReverse(true);
        final KeyFrame kf1 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                gc.setFill(backGroundColor);
                gc.fillRect(playerX, playerY, playerWidth * playerScale, playerHeight * playerScale);
                gc.drawImage(img, 0, 0, playerWidth, playerHeight, playerX, playerY, playerWidth * playerScale, playerHeight * playerScale);
            }
        });
        timeline1.getKeyFrames().addAll(kf1);

        final Timeline timeline2 = new Timeline();
        timeline2.setCycleCount(1);
        //timeline2.setAutoReverse(true);
        final KeyFrame kf2 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                gc.setFill(backGroundColor);
                gc.fillRect(playerX, playerY, playerWidth * playerScale, playerHeight * playerScale);
                gc.drawImage(img, 0, 30, playerWidth, playerHeight, playerX, playerY, playerWidth * playerScale, playerHeight * playerScale);
            }
        });
        timeline2.getKeyFrames().addAll(kf2);

        final Timeline timeline3 = new Timeline();
        timeline3.setCycleCount(1);
        //timeline3.setAutoReverse(true);
        final KeyFrame kf3 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                gc.setFill(backGroundColor);
                gc.fillRect(playerX, playerY, playerWidth * playerScale, playerHeight * playerScale);
                gc.drawImage(img, 0, 60, playerWidth, playerHeight, playerX, playerY, playerWidth * playerScale, playerHeight * playerScale);
            }
        });
        timeline3.getKeyFrames().addAll(kf3);

        SequentialTransition sequence = new SequentialTransition(timeline2, timeline1, timeline3);
        sequence.setCycleCount(Timeline.INDEFINITE);
        sequence.setAutoReverse(true);
        sequence.play();
    }


}
