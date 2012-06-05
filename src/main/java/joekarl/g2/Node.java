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
public abstract class Node implements Renderable, Updatable {

    protected List<Node> childNodes = new ArrayList<Node>();
    private double _posX, _posY,
            _width, _height, _halfWidth, _halfHeight,
            _rotation /*in radians*/, _scale = 1;

    public double getHalfWidth() {
        return _halfWidth;
    }

    public double getHalfHeight() {
        return _halfHeight;
    }

    public double getHeight() {
        return _height;
    }

    public void setHeight(double _height) {
        this._height = _height;
        this._halfHeight = _height / 2;
    }

    public double getPosX() {
        return _posX;
    }

    public void setPosX(double _posX) {
        this._posX = _posX;
    }

    public double getPosY() {
        return _posY;
    }

    public void setPosY(double _posY) {
        this._posY = _posY;
    }

    public double getRotation() {
        return _rotation;
    }

    public void setRotation(double _rotation) {
        this._rotation = _rotation;
    }

    public double getScale() {
        return _scale;
    }

    public void setScale(double _scale) {
        this._scale = _scale;
    }

    public double getWidth() {
        return _width;
    }

    public void setWidth(double _width) {
        this._width = _width;
        this._halfWidth = _width / 2;
    }

    public final void _render(Graphics2D g2d, float interpolation) {
        Dimension halfWindowSize = Director.sharedDirector().halfWindowSize();
        Dimension windowSize = Director.sharedDirector().windowSize();
        AffineTransform tx = new AffineTransform();
        for (Node node : childNodes) {
            tx.setToIdentity();
            tx.translate(halfWindowSize.width + node.getPosX(), halfWindowSize.height + node.getPosY());
            tx.scale(node.getScale(), -node.getScale());
            g2d.setTransform(tx);
            Stroke stroke = g2d.getStroke();
            node.render(g2d, interpolation);
            node._render(g2d, interpolation);
            g2d.setStroke(stroke);
        }
        
    }

    public final void _update() {
        for (Node node : childNodes) {
            node.update();
            node._update();
        }
    }
}
