/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author karl_ctr_kirch
 */
public class Director {

    private static Director g_sharedDirector = null;
    private Scene _runningScene;
    private Renderer _renderer;
    private MainLoop _mainLoop;
    private boolean _showFPS = true;
    private TimeCounter _fpsCounter;

    public static Director sharedDirector() {
        if (g_sharedDirector == null) {
            g_sharedDirector = new Director();
        }
        return g_sharedDirector;
    }

    private Director() {
        _renderer = new Renderer();
        _renderer.addKeyListener(InputManager.getInstance());
        _fpsCounter = new TimeCounter();
    }

    public void runWithScene(Scene scene) {
        if (_runningScene != null) {
            throw new IllegalStateException("Cannot call runWithScene twice");
        }
        _runningScene = scene;

        _mainLoop = new MainLoop(30) {

            String fpsString = "FPS [%.0f]";

            @Override
            public void tick(long dt) {
                InputManager.getInstance().update();
                _runningScene.update();
            }

            @Override
            public void render(float dt) {
                Graphics2D g2d = _renderer.startFrame();
                _runningScene.render(g2d, dt);
                if (_showFPS) {
                    AffineTransform tx = g2d.getTransform();
                    tx.setToIdentity();
                    g2d.setTransform(tx);
                    g2d.setColor(Color.green);
                    g2d.drawString(String.format(fpsString,
                            _fpsCounter.getCountsPerSecond()),
                            10, 24);
                }
                _renderer.endFrame();
                _fpsCounter.tick();
            }
        };
        _mainLoop.run();
    }

    public void replaceScene(Scene s) {
        _runningScene = s;
    }
    
    public Scene getRunningScene() {
        return _runningScene;
    }

    public void pause() {
        _mainLoop.stop();
    }

    public void resume() {
        _mainLoop.run();
    }

    public Dimension windowSize() {
        return _renderer.getCanvasSize();
    }

    public Dimension halfWindowSize() {
        return _renderer.getHalfCanvasSize();
    }

    public boolean isShowFPS() {
        return _showFPS;
    }

    public void setShowFPS(boolean _showFPS) {
        this._showFPS = _showFPS;
    }
}
