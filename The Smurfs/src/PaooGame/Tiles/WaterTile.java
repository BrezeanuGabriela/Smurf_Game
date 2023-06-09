package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class WaterTile extends Tile{
    public WaterTile(int id)
    {
        super(Assets.blue,id);
    }

    @Override
    public boolean IsSolid() {
        return true; //nu putem merge prin apa pentru ca strumful nu stie sa inoate
    }
}
