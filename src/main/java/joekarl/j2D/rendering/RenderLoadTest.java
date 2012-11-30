/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.rendering;

import joekarl.j2D.Director;
import joekarl.j2D.Scene;

/**
 *
 * @author karl_ctr_kirch
 */
public class RenderLoadTest {
    public static void main(String...args) {
        Scene scene = new Scene(){};
        Director d = Director.sharedDirector();
        d.runWithScene(scene);
    }
}
