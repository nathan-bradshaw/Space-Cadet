import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    private int health;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int setBoss = 0;
    private int shoot = 0;
    private int shoot2 = 0;
    private int move = 0;
    private int side;
    public Boss() {
        health = 75;
        image1 = new GreenfootImage("bosshead.png");
        image2 = new GreenfootImage("bosshead2.png");
        setImage(image1);
        GreenfootImage image = getImage();
        image.scale(150, 150);
    }
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkImage();
        moveBoss();
        Ship spaceship = (Ship) getWorld().getObjects(Ship.class).get(0);
        if(shoot == 50) {
            Fireball fball = new Fireball(0);
            side = Greenfoot.getRandomNumber(2) + 1;
            if(side ==1) {
                getWorld().addObject(fball, spaceship.getX()
                    + Greenfoot.getRandomNumber(50), 0);
            }
            if(side ==1) {
                getWorld().addObject(fball, spaceship.getX()
                    - Greenfoot.getRandomNumber(50), 0);
            }
            shoot=0;
        } else {
            shoot++;
        }
        
        if(shoot2 == 200) {
            Fireball fball = new Fireball(1);
            getWorld().addObject(fball, getX(), getY());
            playSound();
            shoot2 = 0;
        } else {
            shoot2++;
        }
    }
    
    private void moveBoss() {
        move++;
        if(move < 90) {
            setLocation(getX() + 1, getY());
        }
        else if(move > 90 && move< 180) {
            setLocation(getX() - 1, getY());
        } else if (move>180){
            move = 0;
        }
    }
    
    private void playSound() {
       GreenfootSound boom = new GreenfootSound("fireball.mp3");
       boom.play();
       boom.setVolume(25);
    }
    public void hit() {
        health -= 1;
        if(health==0) {
            Explosion deathBoom = new Explosion();
            getWorld().addObject(deathBoom, getX(), getY());
            GreenfootImage explode = deathBoom.getImage();
            explode.scale(220, 140);
            winImage win = new winImage();
            getWorld().addObject(win, 300, 200);
            ((OuterSpace)getWorld()).victory();
            getWorld().removeObject(this);
        }
    }
    
    private void checkImage() {
        if (setBoss == 60) {
            changeImage();
            setBoss = 0;
        } else {
            setBoss++;
        }
    }
    private void changeImage() { 
        if (getImage() == image1) { 
            setImage(image2);
            GreenfootImage image = getImage();
            image.scale(140, 140);
        } else {
            setImage(image1);
            GreenfootImage image = getImage();
            image.scale(150, 150);
        }
    }
}
