package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class ButtonsSheet {

    private BufferedImage       buttonsSheet;
    private static final int    tileWidth   = 300; //latimea butonului
    private static final int    tileHeight  = 150; //inaltimea butonului

    public ButtonsSheet(BufferedImage buffImg)
    {
        buttonsSheet = buffImg;

    }

    public BufferedImage crop(int x, int y)
    {
        return buttonsSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }
}
