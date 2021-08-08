import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.util.Calendar;

/**
 * Se utiliza para mostrar el punteo, números y letras
 
 * José Auyón 201579
 
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    /**
     * Scoreboard para testing
     */
    public ScoreBoard()
    {
        this(100);
    }

    /**
     * Muestra el score
     */
    public ScoreBoard(int score)
    {
        if(LevelInt.value == 1 || LevelInt.value == 2)
        {
            makeImage("Perdiste", "Punteo: ", score);
        }
        else if (LevelInt.value == 3)
        {
            makeImage(" ¡Ganaste!", "Punteo: ", score);
        }    
    }

    /**
     * Imagen de scoreboard
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
}
