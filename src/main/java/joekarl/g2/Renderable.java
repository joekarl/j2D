/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2;

import java.awt.Graphics2D;

/**
 *
 * @author karl_ctr_kirch
 */
public interface Renderable {
    void render(Graphics2D g2d, float interpolation);
}
