/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.constants.GlobalConstants;
import java.util.Date;

/**
 *
 * @author ashish.padalkar
 */
public class GameState {
    public static int level;
    public static Date lastSaved;
    public static boolean hasUnsavedChanges;
    public static GlobalConstants.GameStatus gameStatus;
}
