package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PickedApple extends Item{ //clasa corespunzatoare merelor culese
    protected BufferedImage image;

    public PickedApple(RefLinks refLinks, float x, float y) {
        super(refLinks, x, y, Tile.TILE_WIDTH, Tile.TILE_WIDTH);
        image = Assets.apple_picked; //pata rosie
    }
    public void Update()
    {

    }

    public void die()
    {}

    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null );
        //g.setColor(Color.black);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

}
