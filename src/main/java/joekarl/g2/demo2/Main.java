package joekarl.g2.demo2;

import joekarl.g2.Director;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) throws InterruptedException
    {
        Director.sharedDirector().runWithScene(new Demo2Scene());
    }
}
