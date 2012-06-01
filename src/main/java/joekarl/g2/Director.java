/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2;

import java.awt.Dimension;

/**
 *
 * @author karl_ctr_kirch
 */
public class Director {

    private static Director g_sharedDirector = null;

    public static Director sharedDirector() {
        if (g_sharedDirector == null) {
            g_sharedDirector = new Director();
        }
        return g_sharedDirector;
    }

    private Director() {
        _renderer = new Renderer();
    }
    
    private Scene _runningScene;
    private Renderer _renderer;
    private MainLoop _mainLoop;

    public void runWithScene(Scene scene) {
        if (_runningScene != null) {
            throw new IllegalStateException("Cannot call runWithScene twice");
        }
        _runningScene = scene;
        
        _mainLoop = new MainLoop(30){

            @Override
            public void tick(long dt) {
                _runningScene.update();
            }

            @Override
            public void render(float dt) {
                _runningScene.render(_renderer.startFrame(), dt);
                _renderer.endFrame();
            }
        };
        _mainLoop.run();
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
}
