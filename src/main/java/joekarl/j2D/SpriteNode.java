/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author karl_ctr_kirch
 */
public abstract class SpriteNode extends Node {
    
    private Image spriteImage;
    
    public SpriteNode(String spriteImageName) {
        spriteImage = ImageManager.getInstance().loadImage(spriteImageName);
        setWidth(spriteImage.getWidth(null));
        setHeight(spriteImage.getHeight(null));
    }

    public void render(Graphics2D g2d, float interpolation) {
        g2d.drawImage(spriteImage, -getHalfWidthI(), -getHalfHeightI(), null);
    }
    
}
