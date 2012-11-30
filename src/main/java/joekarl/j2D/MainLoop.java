/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.j2D;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karl ctr kirch
 */
public abstract class MainLoop {

    private final long skipTicks;
    private final long maxFrameSkip;
    private long nextTick, lastRender, currentTime;
    private long loops;
    private float interpolation;
    private static final long NANO = 1000000000L;
    private static final long NANO_IN_MILLI = 1000000L;
    private volatile boolean running = false;

    public abstract void tick(long dt);

    public abstract void render(float dt);

    public MainLoop(long ticksPerSecond) {
        this(ticksPerSecond, 5L);
    }

    public MainLoop(long ticksPerSecond, long maxFrameSkip) {
        skipTicks = NANO / ticksPerSecond;
        this.maxFrameSkip = maxFrameSkip;
    }

    public void stop() {
        running = false;
    }

    public void run() {
        if (running == true) {
            throw new IllegalStateException("Main loop already running");
        }
        running = true;
        nextTick = getTime();
        while (running) {
            loops = 0;

            while (getTime() > nextTick && loops < maxFrameSkip) {

                //convert to milliseconds
                tick(skipTicks / NANO_IN_MILLI);
                nextTick += skipTicks;
                loops++;
            }
            currentTime = getTime();

            if (loops >= maxFrameSkip) {
                //System.out.println("Frameskipping");
            }

            render((float) (getTime() + skipTicks - nextTick) / (float) (skipTicks));
            lastRender = currentTime;
            Thread.yield();
        }
    }

    private long getTime() {
        return System.nanoTime();
    }
}
