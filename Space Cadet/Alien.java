import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    protected int health;
    protected int setAlien = 0;
    protected GreenfootImage image1;
    protected GreenfootImage image2;
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkContact();
    }
    
    protected void checkContact() {
        Ship spaceship = (Ship) getOneIntersectingObject(Ship.class);
        if(spaceship != null) {
            spaceship.hit();
            getWorld().removeObject(this); 
        }
    }
    
    public void hit() {
        health = health - 1;
        if(health==0) {
            Explosion boom = new Explosion();
            getWorld().addObject(boom, getX(), getY());
            getWorld().removeObject(this);
        }
    }
    
    
}
