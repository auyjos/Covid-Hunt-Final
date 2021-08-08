import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.nio.file.Paths;
import java.io.*;
/**
 * Trayectoria del virus
 * 
 * José Auyón
 */
public class Cell extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    int a = Greenfoot.getRandomNumber(20);
    LevelInt levelint = new LevelInt("Nivel: ");
    boolean flyingUp = true;
   public Cell()
   {
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
        String path=Paths.get(".").toAbsolutePath().normalize().toString();
        image1 = new GreenfootImage("covidblack.png");
        image2 = new GreenfootImage("covidblue.png");
        setImage(image1);
   }
    
    /**
     * Hacer que la célula vaya de lado
     */ 
    public void act() 
    {
        switchImage();
        /**
         * Nivel 1
         */
        if ( LevelInt.value == 1)
        {
            flyAcross();
        }
        /**
         * Nivel 2 y 3
         */
        if (LevelInt.value == 2 || LevelInt.value == 3)
        {
            flyRandomly();
        }
        //remove Cell when at right border
        if(getX() == 799)
        {
            getWorld().removeObject(this);
        }
        /**
         * Ganar o perder
         */
        if ( LevelInt.value == 1 || LevelInt.value == 2)//Level 1 or 2
        {        
            if (((CellWorld) getWorld()).CellsSeen == 12 && ShotCounter.target < 7) 
            {
                ((CellWorld) getWorld()).gameOver();
                Greenfoot.stop();
            }
            if (((CellWorld) getWorld()).CellsSeen == 12 && ShotCounter.target >= 7) 
            {
                ((CellWorld) getWorld()).nextLevel();
            }
        }
        else if (LevelInt.value == 3)//Level 3
        {
            if (((CellWorld) getWorld()).CellsSeen == 18 && ShotCounter.target < 16) 
            {
                ((CellWorld) getWorld()).gameOver();
                Greenfoot.stop();
            }
            if (((CellWorld) getWorld()).CellsSeen == 18 && ShotCounter.target >= 16) 
            {
                ((CellWorld) getWorld()).nextLevel();
            }
        }
        
    }    
    
    /**
     * Volar arriba y abajo
     */
    public void flyUpRight()
    {
        setLocation (getX() + 2, getY() - 2);
        flyingUp = true;
    }
    
    /**
     * Abajo y derecha
     */
    public void flyDownRight()
    {
        setLocation (getX() + 2, getY() + 2);
        flyingUp = false;
    }
    
    /**
     * Cambiar direcciones
     */
    public void changeDirections()
    {
        if ( flyingUp )
        {
            flyDownRight();
        }
        else
        {
            flyUpRight();
        }
    }
    
    /**
     * No cambiar direcciones
     */
    public void keepFlying()
    {
        if (flyingUp)
        {
            flyUpRight();
        }
        else
        {
            flyDownRight();
        }
    }
    
    /**
     * Movimientos aleatorios
     */
    public void flyRandomly()
    {
        //border check
        if (getY() <= 30)
        {
            flyDownRight();
        }
        else if (getY() >= 427)
        {
            flyUpRight();
        }
        else if(Greenfoot.getRandomNumber(100) <= 1)//Random Movement
        {
            changeDirections();
        }
        else
        {
         keepFlying();   
        }
    }
    /**
     * Volar horizontal
     */
    public void flyAcross()
    {
        setLocation(getX() + 2, getY());
    }
    
    /**
     * Explotar célula
     */
    public void pop() 
    {
        Greenfoot.playSound("covidexplode.wav");
        ((CellWorld) getWorld()).countPop();
        ((CellWorld) getWorld()).countShot();
        getWorld().removeObject(this);
        
    }
    
    /**
     * Alternar imagen 1 y 2
     */
    public void switchImage()
    {
        if (a == 1)
        {
            if (getImage() == image1) 
            {
                setImage(image2);
            }
            else
            {
                setImage(image1);
            }
        }
        a++;
        if (a == 20)
        {
            a = 1;
        }
    }
}
