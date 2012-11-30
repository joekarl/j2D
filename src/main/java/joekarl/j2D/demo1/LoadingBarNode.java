/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D.demo1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import joekarl.j2D.Director;
import joekarl.j2D.Node;

/**
 *
 * @author karl_ctr_kirch
 */
public class LoadingBarNode extends Node {

    double halfWidth, halfHeight;
    Stroke stroke;
    Rectangle2D.Double outerRect, innerRect;
    boolean left = false;

    public LoadingBarNode() {
        Dimension windowSize = Director.sharedDirector().windowSize();
        setWidth(windowSize.width * .5);
        setHeight(25);
        stroke = new BasicStroke(2);
        outerRect = new Rectangle2D.Double(-getHalfWidth(),
                -getHalfHeight(), getWidth(), getHeight());
        innerRect = new Rectangle2D.Double(-getHalfWidth(),
                -getHalfHeight(), 0, getHeight());
    }

    @Override
    public void render(Graphics2D g2d, float interpolation) {
        g2d.setColor(Color.white);
        g2d.setStroke(stroke);
        g2d.draw(outerRect);
        g2d.setColor(Color.GREEN);
        g2d.fill(innerRect);
    }

    public void update(long dt) {
        if (innerRect.width >= getWidth()) {
            Director.sharedDirector().replaceScene(new KeyMoveScene());
            return;
        }
        innerRect.width += 2;
//        if (left) {
//            innerRect.width -= 10;
//        } else {
//            innerRect.width += 10;
//        }
//        
//        if (left && innerRect.width <= 0) {
//            innerRect.width = 0;
//            left = false;
//        } else if (!left && innerRect.width >= getWidth()) {
//            innerRect.width = getWidth();
//            left = true;
//        }
    }
}
