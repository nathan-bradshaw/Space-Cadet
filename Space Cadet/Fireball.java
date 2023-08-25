import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    private GreenfootImage image1;
    private int type;
    public Fireball(int typeIn) {
        type = typeIn;
        image1 = new GreenfootImage("fireball.png");
        setImage(image1);
        GreenfootImage image = getImage();
        if (type == 0) {
            image.scale(35, 60);
        }
        else if (type == 1){
            image.scale(60, 110);
        }
    }
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveFireball();
    }
    private void moveFireball() {
        if (type == 0) {
            setLocation(getX(), getY()+5);
        }
        else if (type == 1){
            setLocation(getX(), getY()+3);
        }
        
        if(getY() > 385) {
            getWorld().removeObject(this);   
        } else {
            checkContact();
        }
    }
    
    private void checkContact() {
        Ship spaceship = (Ship) getOneIntersectingObject(Ship.class);
        if(spaceship != null) {
            spaceship.hit();
            getWorld().removeObject(this);
        }
    }
}
