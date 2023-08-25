import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author Astronauts
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    private static int lives;; //numbers of hits ship can take
    private int gunReloadTime; // The minimum delay between firing the gun.
    private int reloadDelayCount; // How long ago we fired the gun the last time.
    /**
     * Sets the ship up.
     */
    public Ship() {
        gunReloadTime = 20;
        reloadDelayCount = 0;
        GreenfootImage image = getImage();
        image.scale(50, 50);
        lives = 3;
    }
    
    public void hit() {
        Explosion boom = new Explosion();
        getWorld().addObject(boom, getX(), getY());
        GreenfootImage explode = boom.getImage();
        explode.scale(180, 120);
        if(lives==1) {
            String gameOver = "GAME OVER";
            getWorld().showText(gameOver, 290, 200);
            Greenfoot.stop();
        }
        lives--;
    }
    
    public static int getLives() {
        return lives;
    }
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        reloadDelayCount++;
    }
    
    /**
     * Moves the ship side to side and fires.
     */
    public void checkKeys() {
        if(Greenfoot.isKeyDown("left")) {
            setLocation(getX()-4, getY());
        }        
        if(Greenfoot.isKeyDown("right")) {
            setLocation(getX()+4, getY());
        }
        if(Greenfoot.isKeyDown("space")) {
            fire();
        }
    }
    
    
    /**
     * Fire a bullet if the gun is ready.
     */
    public void fire() {
        if(reloadDelayCount >= gunReloadTime) {
            Bullet b = new Bullet(getRotation()-90);
            Bullet b2 = new Bullet(getRotation()-90);
            getWorld().addObject(b, getX()+10, getY());
            getWorld().addObject(b2, getX()-10, getY());
            //speed for bullets
            reloadDelayCount = 0;
        }
    }
}
