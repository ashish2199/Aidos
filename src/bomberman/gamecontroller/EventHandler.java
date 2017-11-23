/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.gamecontroller;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author ashish.padalkar
 */
public class EventHandler {
    public static char lastKeyPress;
    public static char lastKeyReleased;

    public static void attachEventHandlers(Scene s){
        keyReleaseHanlder krh = new keyReleaseHanlder();
        keyPressedHandler kph = new keyPressedHandler();
        s.setOnKeyReleased(krh);
        s.setOnKeyPressed(kph);
    }
}
class keyReleaseHanlder implements javafx.event.EventHandler<KeyEvent>{

    public keyReleaseHanlder() {
    }
    @Override
    public void handle(KeyEvent evt) {
        System.out.println("The key released is : "+evt.getText()+" with keycode "+evt.getCode().getName());

        String code = evt.getCode().toString();

        if ( InputHandler.input.contains(code) )
        	InputHandler.input.remove( code );
    }
}
class keyPressedHandler implements javafx.event.EventHandler<KeyEvent>{
    @Override
    public void handle(KeyEvent evt) {
        System.out.println("The key pressed is : "+evt.getText()+" with keycode "+evt.getCode().getName());

        String code = evt.getCode().toString();

        //https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
        // only add once... prevent duplicates
        if ( !InputHandler.input.contains(code) )
        	InputHandler.input.add( code );
    }
}
