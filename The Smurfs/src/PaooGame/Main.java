package PaooGame;

public class Main {
    public static void main(String[] args)
    {
        //Game paooGame = new Game("The Smurfs", 720, 620);
        //paooGame.startGame();
        Singleton singleton=Singleton.getInstance();
        singleton.game.startGame();
    }
}
