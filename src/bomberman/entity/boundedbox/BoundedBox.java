/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.boundedbox;

/**
 *
 * @author Ashish
 */
public interface BoundedBox {
    /*
        Returns true when two enities are colliding
        Returns false when two entities are not colliding
    */
    boolean checkCollision(BoundedBox b);
    
    /*
        Returns boundary of a entity
    */
    BoundedBox getBoundary();
    
}
