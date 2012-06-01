package joekarl.g2.demo1;

import joekarl.g2.Director;

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
