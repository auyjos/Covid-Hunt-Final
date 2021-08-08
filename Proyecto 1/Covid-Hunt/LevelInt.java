import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)



/**
 * Este actor nos permite llevar cuenta de los números en cada nivel
 * 
 * José Auyón
 
 */
public class LevelInt extends Actor
{
    public static int value = 1;
    private String text;
    private int stringLength;

    public LevelInt()
    {
        this("");
    }

    public LevelInt(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        
        updateImage();
    }
    
    public void act()
    {
        updateImage();
    }

    public void add(int score)
    {
        value += score;
    }


    public int getValue()
    {
        return value;
    }

    /**
     * Hacer imagen de contador
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}
