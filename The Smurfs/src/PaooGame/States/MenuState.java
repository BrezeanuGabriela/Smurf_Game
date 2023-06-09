package PaooGame.States;

import PaooGame.Graphics.ButtonsAssets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;
import PaooGame.UI.PlayButton;
import PaooGame.UI.UIManager;
import PaooGame.UI.AboutButton;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuState extends State //meniul jocului
{
    private BufferedImage background;

    private UIManager uiManager;

    public MenuState(RefLinks refLink)
    {
        super(refLink);

        //incarcam imaginea de fundal
        background=ImageLoader.LoadImage("res/textures/the-smurfs-reboot-nickelodeon-series-order.jpg");

        //construim managerul user interface
        uiManager=new UIManager(refLink);
        ButtonsAssets.init(); //construim assets pt butoane

        //adaugam meniurile pe ecran
        uiManager.addObject(new PlayButton(530f, 240f, 150, 50, ButtonsAssets.play_button));

        uiManager.addObject(new AboutButton(530f, 290f, 150, 50, ButtonsAssets.about_button));
    }

    @Override
    public void Update() //aici vom actualiza starile in functie de comenzi
    {

        //control din mouse

        //setam coordonatele mouse ului pentru care poate apasa play
        if(refLink.GetMouseManager().getMouseX() >= uiManager.getObjectatIndex(0).getX()
                && refLink.GetMouseManager().getMouseX() <= uiManager.getObjectatIndex(0).getX()+uiManager.getObjectatIndex(0).getWidth()
                && refLink.GetMouseManager().getMouseY() >= uiManager.getObjectatIndex(0).getY()
                &&refLink.GetMouseManager().getMouseY() <=uiManager.getObjectatIndex(0).getY() + uiManager.getObjectatIndex(0).getHeight()
                && refLink.GetMouseManager().isLeftPressed())
            {
                State.SetState(refLink.GetGame().playState);
                refLink.GetGame().getGamewindow().GetWindowFrame().requestFocusInWindow();
            }

        //setam coordonatele mouse ului pentru care poate apasa about
        else if(refLink.GetMouseManager().getMouseX() >= uiManager.getObjectatIndex(1).getX()
                && refLink.GetMouseManager().getMouseX() <= uiManager.getObjectatIndex(1).getX()+uiManager.getObjectatIndex(1).getWidth()
                && refLink.GetMouseManager().getMouseY() >= uiManager.getObjectatIndex(1).getY()
                &&refLink.GetMouseManager().getMouseY() <=uiManager.getObjectatIndex(1).getY() + uiManager.getObjectatIndex(1).getHeight()
                && refLink.GetMouseManager().isLeftPressed())
            {
                State.SetState(refLink.GetGame().aboutState);
                refLink.GetGame().getGamewindow().GetWindowFrame().requestFocusInWindow();
            }

        //control din tastatura
        if(refLink.GetKeyManager().space)
           State.SetState(refLink.GetGame().playState);
        if(refLink.GetKeyManager().tasta_a)
           State.SetState(refLink.GetGame().aboutState);
        //System.out.println(refLink.GetMouseManager().getMouseX()+ " "+ refLink.GetMouseManager().getMouseY());
        uiManager.Update();
    }

    @Override
    public void Draw(Graphics g) //desenam background ul si butoanele
    {
        g.drawImage(background,0,0,null);
        //desenam butoanele
        uiManager.Draw(g);
    }
}
