package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Rock2Tile extends Tile{

    public Rock2Tile(int id)
    {
        super(Assets.gray2, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
