package PaooGame;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.Input.MouseManager;
import PaooGame.States.AboutState;
import PaooGame.States.MenuState;
import PaooGame.States.PlayState;
import PaooGame.States.PlayState2;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import PaooGame.States.State;

public class Game implements Runnable{
    private GameWindow gamewindow; //fereastra de joc
    private boolean running; //variabila care ne spune daca jocul inca ruleaza sau daca a fost inchis
    private Thread gameThread; //firul de executie
    private Graphics g;

    private BufferStrategy bs; //pentru buffer ul de imagini

    private RefLinks refLink; //o clasa in care retinem referinte la obiecte din joc pentru a le putea accesa mai usor
    private Tile tile;

    //starile jocului
    public State playState; //starea de joc pentru nivelul 1
    public State playState2;
    public boolean level2creat=false;
    public State menuState; //meniul
    public State aboutState; //povestea jocului si instructiunile

    //input-uri
    private KeyManager keyManager; //de la tastatura
    private MouseManager mouseManager; //de la mouse

    public Game(String title, int width, int height)
    {
        gamewindow = new GameWindow(title, width, height);
        running=false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    public void init()
    {
        gamewindow.BuildGameWindow(); //construim fereastra de joc

        //adaugam input-urile la fereastra
        gamewindow.GetWindowFrame().addKeyListener(keyManager);
        gamewindow.GetWindowFrame().addMouseListener(mouseManager);
        gamewindow.GetWindowFrame().addMouseMotionListener(mouseManager);
        gamewindow.GetCanvas().addMouseListener(mouseManager);
        gamewindow.GetCanvas().addMouseMotionListener(mouseManager);

        //gamewindow.GetWindowFrame().setFocusable(true);
        gamewindow.GetWindowFrame().requestFocusInWindow();

        //construim assets
        Assets.Init();

        //crearea clasei cu referinte catre obiecte
        refLink=new RefLinks(this);

        //crearea starilor de joc
        playState=new PlayState(refLink); //primul nivel
        //playState2=new PlayState2(refLink); //al doilea nivel
        menuState=new MenuState(refLink); //meniul
        aboutState=new AboutState(refLink); //povestea jocului + instructiunile
        State.SetState(aboutState); //jocul se deschide cu aboutstate pentru a sti
        // ce taste corespund comenzilor
    }

    //aici se va implementa game loop
    public void run()
    {
        //initializam componentele jocului
        init();
        //argumente referitoare la timp pt frames per second
        long oldTime=System.nanoTime();
        long currentTime;
        final int FramesPerSecond=60; //vor fi 60 de frame uri pe secunda
        final double timeFrame= 1000000000/FramesPerSecond;
        while(running) //cat timp ruleaza jocul(nu a fost inchis)
        {
            currentTime=System.nanoTime();
            if((currentTime-oldTime)>timeFrame) //calcul necesar pentru a putea sti momentul in
                // care se va face update si draw(cand s-a mai terminat un frame)
            {
                Update();
                Draw();
                oldTime = currentTime;
            }
        }
    }

    public synchronized void startGame()
    {
        if(running==false) //daca jocul nu ruleaza inca
        {
            running=true; //marcam inceputul rularii
            gameThread=new Thread(this); //cream un fir de executie
            gameThread.start(); //va declansa apelarea functiei run() in noul thread
        }
        else
        {
            return;
        }
    }

    public void Update()
    {
        keyManager.Update(); //preluam input-urile de la tastatura
        if(State.GetState() != null)
        {
            State.GetState().Update(); //actualizam starea jocului
            //in functie de ce comenzi dam de la tastatura, vom putea naviga intre menu, about, play
        }

    }

    //functie de desenare
    public void Draw()
    {
        bs=gamewindow.GetCanvas().getBufferStrategy();
        if(bs==null)
        {
            try{
                gamewindow.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        g=bs.getDrawGraphics(); //get graphic object ~=paint brush
        g.clearRect(0,0, gamewindow.getGameWidth(), gamewindow.getGameHeight());

       //trebuie sa obtinem starea curenta pentru a sti ce vom desena
        if(State.GetState()!=null)
        {
            State.GetState().Draw(g); //se va apela functia Draw  din starea curenta
        }

        //afisam in fereastra de joc
        bs.show();
        g.dispose();
    }

    public int GetWidth()
    {
        return gamewindow.getGameWidth();
    }

    public int GetHeight()
    {
        return gamewindow.getGameHeight();
    }

    public KeyManager GetKeyManager()
    {
        return keyManager;
    }

    public MouseManager GetMouseManager() { return mouseManager;}

    public PlayState getPlayState()
    {
        return (PlayState)playState;
        //pentru a putea accesa elemente din playstate
    }

    public PlayState2 getPlayState2()
    {
        return (PlayState2)playState2;
        //pentru a putea accesa elemente din playstate2
    }

    public GameWindow getGamewindow()
    {
        return gamewindow;
    }

}
