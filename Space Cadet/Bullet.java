import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 50;
    
    /** The damage this bullet will deal */
    private int damage = 10;
    
    public Bullet(int rotation)
    {
        setRotation(rotation);
        GreenfootImage image = getImage();
        image.scale(15, 3);
        GreenfootSound boom = new GreenfootSound("laser.mp3");
        boom.play();
        boom.setVolume(15);
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            move(8);
            Alien1 alien1 = (Alien1) getOneIntersectingObject(Alien1.class);
            Alien2 alien2 = (Alien2) getOneIntersectingObject(Alien2.class);
            Alien3 alien3 = (Alien3) getOneIntersectingObject(Alien3.class);
            Rock asteroid = (Rock) getOneIntersectingObject(Rock.class);
            Boss boss = (Boss) getOneIntersectingObject(Boss.class);
            if(alien1 != null && alien2 != null && alien3 != null && asteroid != null) {
                getWorld().removeObject(this);
                alien1.hit();
                asteroid.hit();
            }
            else if(alien1 != null) {
                getWorld().removeObject(this);
                alien1.hit();               
            }
            else if(alien2 != null) {
                getWorld().removeObject(this);
                alien2.hit();               
            }
            else if(alien3 != null) {
                getWorld().removeObject(this);
                alien3.hit();               
            }
            else if(asteroid != null){
                getWorld().removeObject(this);
                asteroid.hit();
            }
            else if(boss != null){
                getWorld().removeObject(this);
                boss.hit();
            }
            else {
                life--;
            }
        }
    }
}
