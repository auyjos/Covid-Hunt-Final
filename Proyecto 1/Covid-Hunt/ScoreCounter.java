import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)



/**
 * Contador de puntos
 * 
 * José Auyón
 * 
 */
public class ScoreCounter extends Actor
{
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;

    public ScoreCounter()
    {
        this("");
    }

    public ScoreCounter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font
        
        updateImage();
    }
    
    public void act() {
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }

    public void add(int score)
    {
        target += score;
    }

    public void subtract(int score)
    {
        target -= score;
    }

    public int getValue()
    {
        return value;
    }

    /**
     * Hace la imagen
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}
