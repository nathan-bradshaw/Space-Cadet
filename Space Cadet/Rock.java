import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    private int health = 5;
    public Rock() {
        //GreenfootImage image = getImage();
        //image.scale(50, 50);
        turn(-90);
    }
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //checkContact();
        moveRock();
    } 
    
    public void hit() {
        health = health - 1;
        if(health==0) {
            Explosion boom = new Explosion();
            getWorld().addObject(boom, getX(), getY());
            getWorld().removeObject(this);
        }
    }
    
    public void checkContact() {
        Ship spaceship = (Ship) getOneIntersectingObject(Ship.class);
        if(spaceship != null) {
            spaceship.hit();
            getWorld().removeObject(this);
        }
    }
    
    public void moveRock() {
        setLocation(getX(), getY() + 3);
        if (getY() > 395) {
            getWorld().removeObject(this);
        }
    }
}
