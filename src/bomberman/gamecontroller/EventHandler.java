/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.gamecontroller;

import bomberman.GameLoop;
import bomberman.constants.Direction;
import bomberman.entity.player.Player;
import bomberman.scenes.Sandbox;
import com.sun.javafx.sg.prism.NGCanvas;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author ashish.padalkar
 */
public class EventHandler {
    public static char lastKeyPress;
    public static char lastKeyReleased;
    
    public static void attachEventHandlers(Scene s){
        keyReleaseHanlder krh = new keyReleaseHanlder(GameLoop.player);
        keyPressedHandler kph = new keyPressedHandler(GameLoop.player);
        s.setOnKeyReleased(krh);
        s.setOnKeyPressed(kph);
    }
}
class keyReleaseHanlder implements javafx.event.EventHandler<KeyEvent>{
    Player player; 

    public keyReleaseHanlder(Player p) {
        this.player=p;
    }
    @Override
    public void handle(KeyEvent evt) {
        player.move(0,Direction.LEFT);
        System.out.println("The key released is : "+evt.getText()+" with keycode "+evt.getCode().getName());
    }
}
class keyPressedHandler implements javafx.event.EventHandler<KeyEvent>{
    Player player; 

    public keyPressedHandler(Player p) {
        this.player=p;
    }
    
    @Override
    public void handle(KeyEvent evt) {
        System.out.println("The key pressed is : "+evt.getText()+" with keycode "+evt.getCode().getName());
        if(evt.getCode()==KeyCode.UP){
            player.move(5,Direction.UP);
        }
        if(evt.getCode()==KeyCode.DOWN){
            player.move(5,Direction.DOWN);
        }
        if(evt.getCode()==KeyCode.LEFT){
            player.move(5,Direction.LEFT);
        }
        if(evt.getCode()==KeyCode.RIGHT){
            player.move(5,Direction.RIGHT);
        }
    }
}
