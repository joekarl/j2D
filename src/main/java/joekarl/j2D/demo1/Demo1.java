package joekarl.j2D.demo1;

import joekarl.j2D.Director;

/**
 * Hello world!
 *
 */
public class Demo1 
{
    public static void main( String[] args ) throws InterruptedException
    {
        Director.sharedDirector().runWithScene(new LoadingScene());
    }
}
