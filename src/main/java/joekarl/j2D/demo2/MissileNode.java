/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.demo2;

import joekarl.j2D.Director;
import joekarl.j2D.SpriteNode;

/**
 *
 * @author karl ctr kirch
 */
public class MissileNode extends SpriteNode {
    int life = 1 * 1000; //1 second

    public MissileNode() {
        super("missile.png");
        setScale(.5);
        setRotation(Math.toRadians(90));
    }

    public void update(long dt) {
        setPosX(getPosX() + 22);
        life -= dt;
        if (life <= 0) {
            Director.sharedDirector().getRunningScene().removeChild(this);
        }
    }
}
