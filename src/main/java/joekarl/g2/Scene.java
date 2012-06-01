/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karl_ctr_kirch
 */
public abstract class Scene implements Renderable, Updatable {

    protected List<Node> nodes = new ArrayList<Node>();

    public void render(Graphics2D g2d, float interpolation) {
        Dimension halfWindowSize = Director.sharedDirector().halfWindowSize();
        Dimension windowSize = Director.sharedDirector().windowSize();
        AffineTransform tx = new AffineTransform();
        for (Node node : nodes) {
            tx.setToIdentity();
            tx.translate(halfWindowSize.width, halfWindowSize.height);
            tx.scale(node.getScale(), -node.getScale());
            g2d.setTransform(tx);
            Stroke stroke = g2d.getStroke();
            node.render(g2d, interpolation);
            g2d.setStroke(stroke);
        }
        tx.setToIdentity();
        g2d.setTransform(tx);
        g2d.setColor(Color.red);
        g2d.drawLine(0, halfWindowSize.height, windowSize.width, halfWindowSize.height);
        g2d.drawLine(halfWindowSize.width, 0, halfWindowSize.width, windowSize.height);
    }

    public void update() {
        for (Node node : nodes) {
            node.update();
        }
    }
}
