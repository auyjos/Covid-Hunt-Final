import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import greenfoot.MouseInfo.*;
/**
 * Puntero para disparar
 * 
 * José Auyón 201579
 * 
 */
public class Crosshair extends Actor
{
    
    /**
     * Crosshair= Mouse
     */
    public void act() 
    {
        // Follow the mouse
        if(Greenfoot.mouseMoved(null)) 
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        
        // Pop
        if(Greenfoot.mouseClicked(null))
        {   
            Greenfoot.playSound("covidshot.wav");
            
            List<Cell> Cells = getObjectsInRange(15, Cell.class);
            if (Cells.size() != 0) 
            {
                Cell Cell = Cells.get(0);
                Cell.pop();
            }
            List<WipeOut> wipeouts = getObjectsInRange(15, WipeOut.class);
            if (wipeouts.size() != 0)
            {
                WipeOut wipeout = wipeouts.get(0);
                wipeout.wipe();
            }
           
         }
     }   
}




