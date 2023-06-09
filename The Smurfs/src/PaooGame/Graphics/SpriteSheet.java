package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage       spriteSheet;
    private static final int    tileWidth   = 180;
    private static final int    tileHeight  = 350;

    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet = buffImg;
    }

    //Metoda crop() returneaza o subimagine din sprite sheet
    //de la adresa (x * latimeDala, y * inaltimeDala)
    public BufferedImage crop(int x, int y)
    {
        return spriteSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }
}
