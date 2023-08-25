import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien2 extends Alien
{
    private int diagonal;
    public Alien2() {
        health = 2;
        image1 = new GreenfootImage("alien2-1.png");
        image2 = new GreenfootImage("alien2-2.png");
        setImage(image1);
        GreenfootImage image = getImage();
        image.scale(50, 50);
        diagonal = Greenfoot.getRandomNumber(2) + 1;
    }
    /**
     * Act - do whatever the Alien2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //checkImage();
        moveAlien();
        super.act();
    }
    
    public void moveAlien() {
        //Ship spaceship = (Ship) getWorld().getObjects(Ship.class).get(0);
        if(diagonal == 1) {
            setLocation(getX() - 1, getY() + 2);
        }
        else if(diagonal == 2) {
            setLocation(getX() + 1, getY() + 2);
        }
        if (getX() > 585) {
            setLocation(5, getY());
        }
        if (getX() < 5) {
            setLocation(585, getY());
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
            image.scale(40, 20);
        } else {
            setImage(image1);
            GreenfootImage image = getImage();
            image.scale(50, 50);
        }
    }
}
