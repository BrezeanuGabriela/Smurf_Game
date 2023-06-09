package PaooGame.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class ButtonsAssets {
    public static BufferedImage play_button;
    public static BufferedImage about_button;

    public ButtonsAssets() {
    }
    public static void init()
    {
        ButtonsSheet buttonsSheet=new ButtonsSheet(ImageLoader.LoadImage("res/textures/buttons.png"));

        if(buttonsSheet==null)
        {
            System.out.println("null init");
        }


        play_button=buttonsSheet.crop(0,0);
        about_button=buttonsSheet.crop(1,0);
    }
}
