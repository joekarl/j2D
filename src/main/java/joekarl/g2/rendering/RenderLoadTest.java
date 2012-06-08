/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2.rendering;

import joekarl.g2.Director;
import joekarl.g2.Scene;

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
