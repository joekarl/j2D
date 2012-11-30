/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.demo2;

import java.awt.event.KeyEvent;
import joekarl.j2D.Director;
import joekarl.j2D.KeyboardInputManager;
import joekarl.j2D.Scene;
import joekarl.j2D.SpriteNode;

/**
 *
 * @author karl_ctr_kirch
 */
public class ShipNode extends SpriteNode {

    KeyboardInputManager input = KeyboardInputManager.getInstance();
    boolean altFire = true;
    int missileOffset = 12;

    public ShipNode() {
        super("alienblaster.png");
        setScale(.5);
    }

    public void update(long dt) {


        if (input.isKeyDown(KeyEvent.VK_LEFT)) {
            setPosX(getPosX() - 10);
        }
        if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
            setPosX(getPosX() + 10);
        }
        if (input.isKeyDown(KeyEvent.VK_UP)) {
            setPosY(getPosY() - 10);
        }
        if (input.isKeyDown(KeyEvent.VK_DOWN)) {
            setPosY(getPosY() + 10);
        }

        if (input.isKeyDown(KeyEvent.VK_SPACE) || input.isKeyDown(KeyEvent.VK_F)) {
            Scene scene = Director.sharedDirector().getRunningScene();
            MissileNode missileNode = new MissileNode();
            missileNode.setPosX(getPosX());
            if (altFire) {
                missileNode.setPosY(getPosY() + missileOffset);
            } else {
                missileNode.setPosY(getPosY() - missileOffset);
            }
            altFire = !altFire;
            scene.addChild(missileNode);
        }
    }
}
