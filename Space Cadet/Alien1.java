import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien1 extends Alien
{
    public Alien1() {
        super();
        health = 2;
        image1 = new GreenfootImage("UFOpos1.png");
        image2 = new GreenfootImage("UFOpos2.png");
        setImage(image1);
        GreenfootImage image = getImage();
        image.scale(50, 50);
    }
    /**
     * Act - do whatever the Alien1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkImage();
        moveAlien();
        super.act();
    }
    
    private void moveAlien() {
        Ship spaceship = (Ship) getWorld().getObjects(Ship.class).get(0);
        setLocation(getX(), getY()+2); 
        if(getX() < spaceship.getX()) {
            setLocation(getX() + 1, getY());
        }
        if(getX() > spaceship.getX()) {
            setLocation(getX() - 1, getY());
        } 
        if (getY() > 385) {
            setLocation(Greenfoot.getRandomNumber(400), 5);
        }
    }
    
    private void checkImage() {
        if (setAlien==40) {
            changeImage();
            setAlien=0;
        } else {
            setAlien++;
        }
    }
    
    private void changeImage() { 
        if (getImage() == image1) { 
            setImage(image2);
            GreenfootImage image = getImage();
            image.scale(50, 50);
        } else {
            setImage(image1);
            GreenfootImage image = getImage();
            image.scale(50, 50);
        }
    }
}
