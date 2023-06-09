package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile
{
    //toate atributele sunt publice si statice pentru a fi incarcate o singura data in memorie
    //si pentru a putea fi accesate din orice parte a codului
    private static final int NO_TILES  = 10; //doar dimensiunea este privata pentru a nu permite acces sa fie modificate
    public static Tile[] tiles = new Tile[NO_TILES]; //vectorul in care vom retine dalele si de care ne vom ajuta
    //la construirea hartii

    public static Tile greenTile = new Rock2Tile(0);
    public static Tile redTile = new RedTile(1);
    public static Tile blueTile = new WaterTile(2);  //apa
    public static Tile grayTile = new RockTile(3);   //piatra(nu poate merge pe ea eroul)
    public static Tile yellowTile = new YellowTile(4);  //pamantul(poate merge pe el)

    public static final int TILE_WIDTH  = 24;   //latimea unei dale in pixeli
    public static final int TILE_HEIGHT = 24;   //inaltimea unei dale in pixeli

    //atributele sunt protected pentru a putea fi mostenite, dar sa nu fie publice oricui
    protected BufferedImage img; //imaginea continuta de fiecare dala
    protected  int id;   //id ului dalei(dupa care va fi identificata)

    //constructorul clasei in care salvam imaginea, id-ul
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;
        tiles[id] = this;
    }

    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {
        //desenam dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean IsSolid()
    {
        return false;
    } //functie cu ajutorul careia vom construi coliziunile cu harta

}
