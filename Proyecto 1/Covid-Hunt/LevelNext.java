import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.util.Calendar;

/**
 * Muestra el scoreboard
 * 
 * José Auyón
 * 
 */
public class LevelNext extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;
    public static int level = 1;
    
    
    private int prevSecond = -1;
    private int counter = 2;
    
    /**
     * Indicador de nive
     */
    public LevelNext()
    {
        this(1);
        LevelInt.value = 1;
    }

    /**
     * Indicador resultado final
     */
    public LevelNext(int level)
    {
        makeImage("Indicador de nivel", "Nivel: ", level);

    }
    
    /**
     * Act
     */
    public void act()
    {
        deleteLevelBoard();
    }
    
    
    /**
     * Remueve el objeto    
     */
    public void deleteLevelBoard()
    {
        Calendar calendar = Calendar.getInstance();
        int sec = calendar.get(Calendar.SECOND);
        if (counter == 0)
        {
            getWorld().removeObject(this);
        }
        if (sec != prevSecond )
        {
            prevSecond = sec;
            counter = counter - 1;
        }
    }
    /**
     * Imagen de indicador de nivel
     */
    private void makeImage(String title, String prefix, int level)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 163, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + level, 60, 200);
        setImage(image);
    }
}
