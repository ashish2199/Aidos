/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.gamecontroller;

import java.util.List;

import bomberman.constants.Direction;
import bomberman.entity.Entity;
import bomberman.entity.player.Player;
import bomberman.entity.staticobjects.BlackBomb;
import bomberman.scenes.Sandbox;
import java.util.Iterator;
import java.util.Vector;
import javafx.scene.input.KeyCode;
/**
 *
 * @author Ashish
 */
public class InputManager {

    public static void handlePlayerMovements(){
        List<KeyCode> keyboardInputs = EventHandler.getInputList();
        Player player = Sandbox.getPlayer();
        //System.err.println(""+keyboardInputs);
        if(keyboardInputs.contains(KeyCode.UP) || keyboardInputs.contains(KeyCode.W)){
            player.move(5,Direction.UP);
        }
        if(keyboardInputs.contains(KeyCode.DOWN) || keyboardInputs.contains(KeyCode.S)){
            player.move(5,Direction.DOWN);
        }
        if(keyboardInputs.contains(KeyCode.LEFT) || keyboardInputs.contains(KeyCode.A)){
            player.move(5,Direction.LEFT);
        }
        if(keyboardInputs.contains(KeyCode.RIGHT) || keyboardInputs.contains(KeyCode.D)){
            player.move(5,Direction.RIGHT);
        }
        if( !keyboardInputs.contains(KeyCode.LEFT) &&
            !keyboardInputs.contains(KeyCode.RIGHT) &&
            !keyboardInputs.contains(KeyCode.UP) &&
            !keyboardInputs.contains(KeyCode.DOWN) &&
            !keyboardInputs.contains(KeyCode.W) &&
            !keyboardInputs.contains(KeyCode.A) &&
            !keyboardInputs.contains(KeyCode.S) &&
            !keyboardInputs.contains(KeyCode.D)
          )
        {
            player.move(0, Direction.DOWN);
        }
        
        //Drop bomb
        if(keyboardInputs.contains(KeyCode.SPACE)){           
            Sandbox.addEntityToGame(new BlackBomb(player.getPositionX(), player.getPositionY()));
        }        
    }

}
