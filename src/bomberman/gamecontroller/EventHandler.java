/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.gamecontroller;

import java.util.ArrayList;
import java.util.List;

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
    public static ArrayList<KeyCode> inputList = new ArrayList<KeyCode>();

    public static void attachEventHandlers(Scene s){
        keyReleaseHanlder krh = new keyReleaseHanlder();
        keyPressedHandler kph = new keyPressedHandler();
        s.setOnKeyReleased(krh);
        s.setOnKeyPressed(kph);
    }

    public boolean isKeyDown(KeyCode k) {
    	if( inputList.contains(k)){
    		return true;
        }else{
            return false;
        }
    }
    
    public static List getInputList(){
        return inputList;
    }
}

class keyReleaseHanlder implements javafx.event.EventHandler<KeyEvent>{
    public keyReleaseHanlder() {
    }
    @Override
    public void handle(KeyEvent evt) {
        //System.out.println("The key released is : "+evt.getText()+" with keycode "+evt.getCode().getName());

        KeyCode code = evt.getCode();

        if ( EventHandler.inputList.contains(code) )
        	EventHandler.inputList.remove( code );
    }
}
class keyPressedHandler implements javafx.event.EventHandler<KeyEvent>{
    @Override
    public void handle(KeyEvent evt) {
        //System.out.println("The key pressed is : "+evt.getText()+" with keycode "+evt.getCode().getName());
        KeyCode code = evt.getCode();
        
        // only add once... prevent duplicates
        if ( !EventHandler.inputList.contains(code) )
        	EventHandler.inputList.add( code );
    }
}
