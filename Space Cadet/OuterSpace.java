import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author Astronauts 
 * @version (a version number or a date)
 */
public class OuterSpace extends World
{
    private double gameRunTime = 0.0;
    private int stage = 1;
    private boolean bossSpawned = false;
    private GreenfootSound l1 = new GreenfootSound("level1.mp3");
    private GreenfootSound l2 = new GreenfootSound("level2.mp3");
    private GreenfootSound l3 = new GreenfootSound("level3.mp3");
    private GreenfootSound l4 = new GreenfootSound("level4.mp3");
    private GreenfootSound win = new GreenfootSound("victoryScreech.mp3");
    private Stage1 s1 = new Stage1();
    private Stage2 s2 = new Stage2();
    private Stage3 s3 = new Stage3();
    private StageFinal s4 = new StageFinal();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public OuterSpace()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //Greenfoot.setWorld(new TitleScreen());
        createHUD();
        createShip();
        //Greenfoot.playSound("level1.mp3");
        playMusic();
        setPaintOrder(Explosion.class, Ship.class, Fireball.class, Boss.class,
            Alien1.class, Alien2.class, Alien3.class, Rock.class);
        setStage();
    }
    
    public void act()
    {
        scroll();
        createHUD();
        gameRunTime+= 0.02;
        if(stage != 4) {
            randomRocks();
        }
        if(stage != 4) {
            createAliens();
        }
        if(gameRunTime >= 60 && stage < 4) {
            stage++;
            gameRunTime = 0;
            if(stage==2)
                l1.stop();
            else if(stage==3)
                l2.stop();
            else if(stage==4)
                l3.stop();
            playMusic();
            if(stage==2)
                removeObject(s1);
            else if(stage==3)
                removeObject(s2);
            else if(stage==4)
                removeObject(s3);
            setStage();
        }
        if(stage == 4 && bossSpawned == false) {
            spawnBoss();
        }
    }

    private void createHUD() {
        /*String stageOne = "Stage " + stage;
        showText(stageOne, 60, 380);*/
        String lives = "Lives: "+ Ship.getLives();
        showText(lives, 540, 380);
        String score = "Time: " + (int) gameRunTime;
        showText(score, 60, 20);
        //String shield = "Shield: (Off)";
        //showText(shield, 500, 20);
    }
    
    private void setStage() {
        
        if(stage==1) {
            addObject(s1, 60, 385);
            GreenfootImage image = s1.getImage();
            image.scale(130, 130);
        }
        if(stage==2) {
            addObject(s2, 60, 385);
            GreenfootImage image = s2.getImage();
            image.scale(130, 130);
        }
        if(stage==3) {
            addObject(s3, 60, 385);
            GreenfootImage image = s3.getImage();
            image.scale(130, 130);
        }
        if(stage==4) {
            addObject(s4, 60, 365);
            GreenfootImage image = s4.getImage();
            image.scale(130, 130);
        }
    }
    
    private void createAliens() {
        if(stage == 1) {
            if(1  > Greenfoot.getRandomNumber(80)) { 
                addObject(new Alien1(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
        }
        if(stage == 2) {
            if(1  > Greenfoot.getRandomNumber(150)) { 
                addObject(new Alien1(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
            if(1  > Greenfoot.getRandomNumber(180)) { 
                addObject(new Alien2(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
        }
        if(stage == 3) {
            if(1  > Greenfoot.getRandomNumber(220)) { 
                addObject(new Alien1(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
            if(1  > Greenfoot.getRandomNumber(250)) { 
                addObject(new Alien2(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
            if(1  > Greenfoot.getRandomNumber(210)) { 
                addObject(new Alien3(), Greenfoot.getRandomNumber(getWidth()-140)+70, 0);
            }
        }
    }
    
    private void spawnBoss() {
        List<Alien> aliens = getObjects(Alien.class);
        removeObjects(aliens);
        addObject(new Boss(), 260, 100);
        bossSpawned = true;
    }
    
    private void randomRocks() {
        if(stage == 1)
            if(1  > Greenfoot.getRandomNumber(100)) { 
                addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
        if(stage == 2)
            if(1  > Greenfoot.getRandomNumber(150)) { 
                addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
        if(stage == 3) {
            if(1  > Greenfoot.getRandomNumber(230)) { 
                addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()), 0);
            }
        }
    }
    
    private void createShip() {
        addObject(new Ship(), 300, 360);
    }
    
    private void playMusic() {
        if(stage == 1) {
           l1.playLoop();
           l1.setVolume(15);
       }
       if(stage == 2) {
           
           l2.playLoop();
           l2.setVolume(15);
       }
       if(stage == 3) {
           l2.stop();
           l3.playLoop();
           l3.setVolume(15);
       }
       if(stage == 4) {
           l3.stop();
           l4.playLoop();
           l4.setVolume(15);
       }
    }
    
    public void victory() {
        l4.stop();
        win.playLoop();
        win.setVolume(20);
    }
    
    private void scroll() {
        GreenfootImage bg = new GreenfootImage(getBackground());
        getBackground().drawImage(bg, 0, 2);
        getBackground().drawImage(bg, 0, 2 - getHeight());
    }
}
