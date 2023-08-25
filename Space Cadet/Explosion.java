import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int life = 20;
    public Explosion() {
        GreenfootImage image = getImage();
        image.scale(150, 90);
        GreenfootSound boom = new GreenfootSound("explosion.mp3");
        boom.play();
        boom.setVolume(25);
    }
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        }
        life--;
    }    
}
