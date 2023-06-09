package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class RockTile extends Tile{ //piatra pe care nu poate emrge
    public RockTile(int id)
    {
        super(Assets.gray, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
