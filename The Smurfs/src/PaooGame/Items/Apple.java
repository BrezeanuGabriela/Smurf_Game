package PaooGame.Items;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import PaooGame.Graphics.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Apple extends Item{
    protected BufferedImage image;
    public Apple(RefLinks refLinks, float x, float y)
    {
        super(refLinks,x,y, Tile.TILE_WIDTH,Tile.TILE_WIDTH);
        image= Assets.apple;

        //setam dreptunghiul de coliziune
        normalBounds.x = 1;
        normalBounds.y = 3;
        normalBounds.width = 21;
        normalBounds.height = 20;
    }

    public void Update()
    {

    }
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null );
        //g.setColor(Color.black);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

    @Override
    public void die()
    {
        //vom adauga marul in manager-ul de mere preluate de pe harta
        refLink.GetGame().getPlayState().getPickedAppleManager().
                addItem(new PickedApple(refLink,x,y));
    }
}
