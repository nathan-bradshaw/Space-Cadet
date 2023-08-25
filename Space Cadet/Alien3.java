import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien3 extends Alien
{
    private int move = 0;
    public Alien3() {
        health = 4;
        image1 = new GreenfootImage("alien3.png");
        setImage(image1);
        GreenfootImage image = getImage();
        image.scale(75, 75);
    }
    /**
     * Act - do whatever the Alien3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveAlien();
        checkContact();
    } 
    
    public void moveAlien() {
        //Ship spaceship = (Ship) getWorld().getObjects(Ship.class).get(0);
        move++;
        setLocation(getX(), getY()+1);
        if(move < 80) {
            setLocation(getX() + 1, getY());
        }
        else if(move > 80 && move< 160) {
            setLocation(getX() - 1, getY());
        } else if (move>160){
            move = 0;
        }
        
        if (getY() > 385) {
            setLocation(Greenfoot.getRandomNumber(400), 5);
        }
    }
    
    public void hit() {
        health = health - 1;
        if(health==0) {
            Explosion boom = new Explosion();
            GreenfootImage explode = boom.getImage();
            explode.scale(220, 140);
            getWorld().addObject(boom, getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
