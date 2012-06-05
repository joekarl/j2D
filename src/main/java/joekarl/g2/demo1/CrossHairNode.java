/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2.demo1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import joekarl.g2.Director;
import joekarl.g2.Node;

/**
 *
 * @author karl
 */
public class CrossHairNode extends Node {

    public void render(Graphics2D g2d, float interpolation) {
        Dimension halfWindowSize = Director.sharedDirector().halfWindowSize();
        Dimension windowSize = Director.sharedDirector().windowSize();
        AffineTransform tx = g2d.getTransform();
        tx.setToIdentity();
        g2d.setTransform(tx);
        g2d.setColor(Color.red);
        g2d.drawLine(0, halfWindowSize.height, windowSize.width, halfWindowSize.height);
        g2d.drawLine(halfWindowSize.width, 0, halfWindowSize.width, windowSize.height);
    }

    public void update() {
        
    }
}
