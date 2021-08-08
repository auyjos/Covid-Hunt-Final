import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot MouseInfo)
import java.util.List;

/** 
 *
 * Mundo 
 
 * José Auyón
 */
public class CellWorld extends World 
{
    ScoreCounter scorecounter = new ScoreCounter("Punteo: ");
    ShotCounter shotcounter = new ShotCounter("Disparados: ");
    LevelInt levelint = new LevelInt("Nivel: ");
    
        
    public static int CellsSeen = 0;
    /**
     *Constructor de objetos
     * 
     */   
    public CellWorld()
    {   
        super(800, 457, 1);
        
        // Actores en respectivo orden
        setPaintOrder(ScoreBoard.class, LevelNext.class, Crosshair.class, Cell.class, ScoreCounter.class, ShotCounter.class, WipeOut.class);
        
        // Añade actores principales
        populate();
        
        
        LevelInt.value = 1;
        
     }  
             
     
    /**
     * Chequea si no hay células en el mundo, si no hay crea algunas
     */
    public void act() 
    {
       /**
         * Nivel 1 y 2
         */
        if ( LevelInt.value == 1 || LevelInt.value == 2)
        {
            List<Cell> Cells = getObjects(Cell.class);
            if (Cells.isEmpty())
                {
                    addObject(new Cell(), 0, Greenfoot.getRandomNumber(600));
                    addObject(new Cell(), 0, Greenfoot.getRandomNumber(600));    
                    CellsSeen+=2;
                }
        }
        /**
         * Level 3.
         */
        if (LevelInt.value == 3)
        {
            List<Cell> Cells = getObjects(Cell.class);
            if (Cells.isEmpty())
                {
                    addObject(new Cell(), 0, Greenfoot.getRandomNumber(600));
                    addObject(new Cell(), 0, Greenfoot.getRandomNumber(600));
                    addObject(new Cell(), 0, Greenfoot.getRandomNumber(600)); 
                    CellsSeen+=3;
                }            
        }
       
    }

    /**
     * Cuenta disparos y Células destruidadas
     */
    public void countPop()
    {
        /**
         * Nivel 1
         */
        if ( LevelInt.value == 1)
        {
            scorecounter.add(20);          
        }
        /**
         * Nivel 2
         */
        if ( LevelInt.value == 2)
        {
            scorecounter.add(50);          
        }
        /**
         * Nivel 3.
         */
        if ( LevelInt.value == 3)
        {
            scorecounter.add(100);          
        }
    }
    
    /**
     * Cuenta el número de células disparadas
     */
    public void countShot()
    {
        shotcounter.add(1);
    }
    
    /**
     * Cuenta el número de células eliminadas
     */
    public void countWipe()
    {
        /**
         * Nivel 1
         */
        if ( LevelInt.value == 1)
        {
            shotcounter.add(2);
            scorecounter.add(40);
        }
        /**
         * Nivel 2
         */
        if (LevelInt.value == 2)
        {
            shotcounter.add(2);
            scorecounter.add(100);
        }/**
         * Nivel 3.
         */
        if (LevelInt.value == 3)
        {
            shotcounter.add(3);    
            scorecounter.add(300);
        }

    }
    
    
    /**
     * Se muestra cuando el juego termina y llama el punteo
     */
    public void gameOver() 
    {       
        addObject(new ScoreBoard(scorecounter.getValue()), getWidth()/2, getHeight()/2);
        Greenfoot.playSound("winsound.wav");
        ShotCounter.target = 0;
        CellsSeen = 0;
       Greenfoot.stop();
    }
    
    /**
     * Se llama cuando se pasa al próximo nivel
     */
    public void nextLevel() 
    {
        levelint.add(1);
        addObject(new LevelNext(levelint.getValue()), getWidth()/2, getHeight()/2);
        if(LevelInt.value == 1 || LevelInt.value == 2)
        {         
            ShotCounter.target = 0;
            CellsSeen = 2;
        }
        else if(LevelInt.value == 3)
        {
            ShotCounter.target = 0;
            CellsSeen = 3;
        }
    }

    /**
     * Añade al mundo el crosshair y contadores
     */
    private void populate()
    {
        addObject(scorecounter, 100, 440);
        addObject(new Crosshair(), 400,300);
        addObject(shotcounter, 760, 15);
        addObject(levelint, 760, 440);
        addObject(new WipeOut(), 650,430);
        addObject(new LevelNext(levelint.getValue()), getWidth()/2, getHeight()/2);
    }  
}
