package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import PaooGame.Graphics.Animation;
import PaooGame.Input.KeyManager;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;

    //animatiile eroului
    private Animation animation_left;
    private Animation animation_right;
    private Animation animation_stand;
    private Animation animation_down;
    private Animation animation_up;

    public Hero(RefLinks refLink, float x, float y)
    {
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        animation_left=new Animation();
        animation_left.setFrames(Assets.heroLeft);
        animation_left.setDelay(100);

        animation_right=new Animation();
        animation_right.setFrames(Assets.heroRight);
        animation_right.setDelay(100);

        animation_stand=new Animation();
        animation_stand.setFrames(Assets.herostand);
        animation_stand.setDelay(100);

        animation_down=new Animation();
        animation_down.setFrames(Assets.herofront);
        animation_down.setDelay(250);

        animation_up=new Animation();
        animation_up.setFrames(Assets.heroback);
        animation_up.setDelay(250);

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 3;
        normalBounds.y = 4;
        normalBounds.width = 11;
        normalBounds.height = 12;
    }


    @Override
    public void Update()
    {
        GetInput();
        Move();

        //Actualizeaza animatiile
        if(refLink.GetKeyManager().left == true)
        {

            animation_left.update();
        }
        else if(refLink.GetKeyManager().right == true) {
            animation_right.update();
       }
        else if(refLink.GetKeyManager().down==true)
        {
            animation_down.update();
        }
        else if(refLink.GetKeyManager().up==true)
        {
            animation_up.update();
        }
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului
     */
    private void GetInput() {
        //daca nu se apasa vreo tasta pentru deplasare, eroul nu trebuie sa se miste
        xMove = 0;
        yMove = 0;

        if (refLink.GetKeyManager().up) //a fost apasata tasta sus pentru deplasarea in sus
        {
            yMove = -speed;
        }
       if (refLink.GetKeyManager().down) //a fost apasata tasta jos pentru deplasarea un jos
       {
                yMove = speed;
       }
       if (refLink.GetKeyManager().left) //a fost apasata tasta stanga pentru deplasarea la stanga
       {
                xMove = -speed;
       }
       if (refLink.GetKeyManager().right) //a fost apasata tasta dreapta pentru deplasarea un josla dreapta
       {
                xMove = speed;
       }
    }

    @Override
    public void Draw(Graphics g)
    {
       g.drawImage(getCurrentAnimationFrame(), (int)x, (int)y, width, height, null);
        // g.drawImage(image, (int)x, (int)y, width, height, null);
        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        Font myFont=new Font("Serif",Font.BOLD,18);
        g.setFont(myFont);
        g.drawString("Scor: "+refLink.getPlayState().getPickedAppleManager().getSize(), 580,615);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove <0) {
            return animation_left.getCurrentFrame();
        }
        else if(xMove>0)
        {
            return animation_right.getCurrentFrame();
        }
        else if(xMove==0&&yMove==0)
        {
            return animation_stand.getCurrentFrame();
        }
        else if(yMove<0)
        {
            return animation_up.getCurrentFrame();
        }
        else if(yMove>0)
        {
            return animation_down.getCurrentFrame();
        }
        else
        {
            return animation_stand.getCurrentFrame();
        }
    }

    @Override
    public void die()
    {
        System.out.println("You lose!");
    }
}
