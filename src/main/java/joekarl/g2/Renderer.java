/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author karl_ctr_kirch
 */
public class Renderer extends JFrame {

    private Canvas canvas;
    private Graphics2D graphics, bufferGraphics;
    private BufferStrategy bufferStrategy;
    private int I_WIDTH = 800, I_HEIGHT = 600,
            HALF_WIDTH = I_WIDTH / 2, HALF_HEIGHT = I_HEIGHT / 2;
    private Dimension halfCanvasSize = new Dimension(HALF_WIDTH, HALF_HEIGHT);
    private BufferedImage backgroundBuffer;

    public Renderer() {
        this.setIgnoreRepaint(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(I_WIDTH, I_HEIGHT));
        contentPane.add(canvas);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        canvas.createBufferStrategy(2);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gs.getDefaultConfiguration();
        backgroundBuffer = gc.createCompatibleImage(I_WIDTH, I_HEIGHT);
    }

    public Graphics2D startFrame() {
        if (graphics != null) {
            throw new IllegalStateException("Must call endFrame before calling startFrame again");
        }
        bufferStrategy = canvas.getBufferStrategy();
        graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        bufferGraphics = backgroundBuffer.createGraphics();
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.fillRect(0, 0, I_WIDTH, I_HEIGHT);
        //bufferGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        return bufferGraphics;
    }

    public void endFrame() {
        if (bufferGraphics != null) {
            bufferGraphics.dispose();
            bufferGraphics = null;
        }
        if (graphics != null) {
            graphics.drawImage(backgroundBuffer, null, 0, 0);
            graphics.dispose();
            graphics = null;
        }
        if (!bufferStrategy.contentsLost()) {
            bufferStrategy.show();
            Toolkit.getDefaultToolkit().sync();
        }
    }

    public Dimension getCanvasSize() {
        return canvas.getPreferredSize();
    }

    public Dimension getHalfCanvasSize() {
        return halfCanvasSize;
    }
}
