/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.demo1;

import joekarl.j2D.Scene;

/**
 *
 * @author karl_ctr_kirch
 */
public class LoadingScene extends Scene {
    public LoadingScene() {
        childNodes.add(new LoadingBarNode());
    }
}
