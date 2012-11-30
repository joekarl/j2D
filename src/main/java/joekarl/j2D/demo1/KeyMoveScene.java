/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.demo1;

import joekarl.j2D.Scene;

/**
 *
 * @author karl
 */
public class KeyMoveScene extends Scene {
    public KeyMoveScene() {
        childNodes.add(new BallNode());
        childNodes.add(new CrossHairNode());
    }

}
