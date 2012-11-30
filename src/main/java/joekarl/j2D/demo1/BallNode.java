/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.demo1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import joekarl.j2D.KeyboardInputManager;
import joekarl.j2D.Node;

/**
 *
 * @author karl
 */
public class BallNode extends Node {

    KeyboardInputManager input = KeyboardInputManager.getInstance();

    public void render(Graphics2D g2d, float interpolation) {
        g2d.setColor(Color.blue);
        g2d.fillOval(-10, -10, 20, 20);
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
    }
}
