/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2.demo1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import joekarl.g2.InputManager;
import joekarl.g2.Node;

/**
 *
 * @author karl
 */
public class BallNode extends Node {

    InputManager input = InputManager.getInstance();

    public void render(Graphics2D g2d, float interpolation) {
        g2d.setColor(Color.BLUE);
        g2d.fillOval(-10, -10, 20, 20);
    }

    public void update() {
        if (input.isKeyDown(KeyEvent.VK_LEFT)) {
            setPosX(getPosX() - 10);
        }
        if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
            setPosX(getPosX() + 10);
        }
        if (input.isKeyDown(KeyEvent.VK_UP)) {
            setPosX(getPosY() - 10);
        }
        if (input.isKeyDown(KeyEvent.VK_DOWN)) {
            setPosX(getPosY() + 10);
        }
    }
}
