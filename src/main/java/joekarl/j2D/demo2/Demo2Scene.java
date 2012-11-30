/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.demo2;

import joekarl.j2D.Scene;

/**
 *
 * @author karl
 */
public class Demo2Scene extends Scene {
    public Demo2Scene() {
        childNodes.add(new ShipNode());
        childNodes.add(new CrossHairNode());
    }

    
}
