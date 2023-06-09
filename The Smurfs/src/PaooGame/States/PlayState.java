package PaooGame.States;

//import PaooGame.Items.Hero;
import PaooGame.Items.*;
import PaooGame.Items.PickedAppleManager;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import javax.swing.*;
import java.awt.*;

//nivelul 1
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    private Apple apple;
    private EntityManager entityManager; //in acest manager de entitati vom avea toate entitatile din joc
    private PickedAppleManager pickedAppleManager; //manager-ul merelor culese

    public PlayState(RefLinks refLink)
    {
        super(refLink);
        map = new Map(refLink, "src/PaooGame/Maps/maplevel1.txt");
        refLink.SetMap(map);
        //construim manager-ul de entitati cu eroul in el
        entityManager=new EntityManager(refLink, new Hero(refLink,24, 0));
       //adaugam 5 mere
        entityManager.addEntity(new Apple(refLink,670,24));
        entityManager.addEntity(new Apple(refLink,456,503));
        entityManager.addEntity(new Apple(refLink,168,312));
        entityManager.addEntity(new Apple(refLink,337,311));
        entityManager.addEntity(new Apple(refLink,24,550));

        pickedAppleManager=new PickedAppleManager(refLink);
    }

    @Override
    public void Update()
    {
        map.Update();
        entityManager.Update();
        pickedAppleManager.Update();
    }

    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        entityManager.Draw(g);
        //pickedAppleManager.Draw(g); //pata rosie in urma merelor
    }

    /*
    public void displayPopup()
    {
       // if(refLink.getPlayState().getPickedAppleManager().getSize()==0)
        //{
            JOptionPane pop=new JOptionPane(null, JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showInternalMessageDialog(null, "You picked 5 apples!\n " +
                    "Now you can receive the key from the cat! " ,"Congratulation!", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.CLOSED_OPTION;

        //}
    }

     */

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public PickedAppleManager getPickedAppleManager() { return pickedAppleManager;}

    public Map getMap()
    {
        return map;
    }
}
