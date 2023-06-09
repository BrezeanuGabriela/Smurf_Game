package PaooGame;

import PaooGame.Input.MouseManager;
import PaooGame.Maps.Map;
import PaooGame.States.PlayState;
import PaooGame.States.PlayState2;
import PaooGame.States.State;
import PaooGame.Input.KeyManager;

public class RefLinks
{
    private Game game;
    private Map map;

    public RefLinks(Game game)
    {
        this.game = game;
    }

    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }

    public MouseManager GetMouseManager() { return game.GetMouseManager(); }

    public int GetWidth()
    {
        return game.GetWidth();
    }

    public int GetHeight()
    {
        return game.GetHeight();
    }

    public Game GetGame()
    {
        return game;
    } //cu ajutorul acestei functii
    //vom putea in orice clasa sa accesam atribute publice/metode in clasa game

    public void SetGame(Game game)
    {
        this.game = game;
    }

    public Map GetMap()
    {
        return map;
    }

    public void SetMap(Map map)
    {
        this.map = map;
    }

    public PlayState getPlayState()
    {
        return game.getPlayState();
    }

    public PlayState2 getPlayState2()
    {
        return game.getPlayState2();
    }
}
