/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2.demo2;

import java.awt.event.KeyEvent;
import joekarl.g2.KeyboardInputManager;
import joekarl.g2.SpriteNode;

/**
 *
 * @author karl_ctr_kirch
 */
public class ShipNode extends SpriteNode {

    KeyboardInputManager input = KeyboardInputManager.getInstance();

    public ShipNode() {
        super("alienblaster.png");
        setScale(.5);
    }

    public void update() {
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
    }
}
