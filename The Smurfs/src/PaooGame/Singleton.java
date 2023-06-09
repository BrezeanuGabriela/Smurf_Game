package PaooGame;

public class Singleton {
    public Game game;
    private static Singleton instance=new Singleton();
    private Singleton()
    {
        game=new Game("The Smurfs", 720, 620);
    }

    public static Singleton getInstance()
    {
        return instance;
    }
}
