package joekarl.j2D.demo2;

import joekarl.j2D.Director;

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
