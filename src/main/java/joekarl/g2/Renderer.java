/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
    private int I_WIDTH = 600, I_HEIGHT = 480,
            HALF_WIDTH = I_WIDTH / 2, HALF_HEIGHT = I_HEIGHT / 2,
            NUM_BUFFERS = 1;
    private Dimension halfCanvasSize = new Dimension(HALF_WIDTH, HALF_HEIGHT);
    private BufferedImage backgroundBuffer;

    public Renderer() {
        this.setIgnoreRepaint(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        canvas = new Canvas();
        canvas.setIgnoreRepaint(true);
        canvas.setPreferredSize(new Dimension(I_WIDTH, I_HEIGHT));
        contentPane.add(canvas);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        canvas.createBufferStrategy(NUM_BUFFERS);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gs.getDefaultConfiguration();
        backgroundBuffer = gc.createCompatibleImage(I_WIDTH, I_HEIGHT);
        bufferStrategy = canvas.getBufferStrategy();
    }

    public Graphics2D startFrame() {
        if (graphics != null) {
            throw new IllegalStateException("Must call endFrame before calling startFrame again");
        }
        bufferGraphics = backgroundBuffer.createGraphics();
        bufferGraphics.clearRect(0, 0, I_WIDTH, I_HEIGHT);
        //bufferGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        return bufferGraphics;
    }

    public void endFrame() {

        graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        graphics.drawImage(backgroundBuffer, null, 0, 0);

        try {
            if (!bufferStrategy.contentsLost()) {
                bufferStrategy.show();
                //Toolkit.getDefaultToolkit().sync();
                Thread.yield();
            }
        } finally {
            if (bufferGraphics != null) {
                bufferGraphics.dispose();
                bufferGraphics = null;
            }
            if (graphics != null) {
                graphics.dispose();
                graphics = null;
            }
        }
    }

    public Dimension getCanvasSize() {
        return canvas.getPreferredSize();
    }

    public Dimension getHalfCanvasSize() {
        return halfCanvasSize;
    }
}
