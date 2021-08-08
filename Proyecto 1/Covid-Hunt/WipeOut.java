import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

// Sirve para destruir todas las células y para testear el punteo
public class WipeOut extends Actor
{
    public void wipe() 
    {
        List<Cell> Cells = getWorld().getObjects(Cell.class);
        Greenfoot.playSound("explosion.wav");
        ((CellWorld) getWorld()).countWipe();
        getWorld().removeObjects(Cells); 
    }    
}