package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage []heroLeft=new BufferedImage[4];
    public static BufferedImage []heroRight=new BufferedImage[5];
    public static BufferedImage []herofront=new BufferedImage[3];
    public static BufferedImage []herostand=new BufferedImage[1];
    public static BufferedImage []heroback=new BufferedImage[4];

    public static BufferedImage gray2;
    public static BufferedImage red;
    public static BufferedImage blue;
    public static BufferedImage yellow;
    public static BufferedImage gray;

    public static BufferedImage apple;
    public static BufferedImage apple_picked;

    public static void Init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("res/textures/sprite2.png"));

        //obtinem assets-urile
        gray = sheet.crop(7, 0);
        gray2 = sheet.crop(8, 0);
        red=sheet.crop(9,0);
        yellow=sheet.crop(8,1);
        blue = sheet.crop(9, 1);

        heroLeft[0] = sheet.crop(0, 2);
        heroLeft[1] = sheet.crop(1,2);
        heroLeft[2]=sheet.crop(2,2);
        heroLeft[3]=sheet.crop(3,2);

        heroRight[0] = sheet.crop(4, 2);
        heroRight[1] = sheet.crop(5, 2);
        heroRight[2] = sheet.crop(6, 2);
        heroRight[3] = sheet.crop(8, 2);
        heroRight[4] = sheet.crop(7, 2);

        herostand[0]=sheet.crop(0,0);

        herofront[0]=sheet.crop(0,0);
        herofront[1]=sheet.crop(1,0);
        herofront[2]=sheet.crop(2,0);

        heroback[0]= sheet.crop(0,1);
        heroback[1]= sheet.crop(1,1);
        heroback[2]= sheet.crop(2,1);
        heroback[3]= sheet.crop(3,1);

        apple= sheet.crop(6,1);
        apple_picked= sheet.crop(5,1);
    }
}
