package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.States.State;

import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    private RefLinks refLinks;
    private Hero Smurf;
    private ArrayList<Item> items; //arraylist pt a avea libertate in ce priveste dimensiunea vectorului

    public EntityManager(RefLinks refLinks, Hero hero)
    {
        this.refLinks=refLinks;
        Smurf=hero;
        items=new ArrayList<Item>();
        addEntity(hero);
    }

    public void addEntity(Item item)
    {
        items.add(item);
    }

    public void Update()
    {
        for(int i=0;i<items.size();i++)
        {
            Item item=items.get(i);
            item.Update();
            if(!item.getActive()) //daca active=false corespunzator item-ului(si-a terminat viata)
               items.remove(item); //il vom indeparta din lista de entitati
        }
        //System.out.println(items.size());
    }

    public void Draw(Graphics g)
    {
        items.get(0).Draw(g); //eroul mereu il desenam
        for(int i=1;i<items.size();i++)
        {
            Item item=items.get(i);
            if(State.GetState()==refLinks.GetGame().playState)
                    item.Draw(g);

        }
        //Smurf.Draw(g);
    }

    //Getters and setters
    public EntityManager getEntityManager()
    {
        return getEntityManager();
    }


    public Hero GetHero()
    {
        return Smurf;
    }

    public void setSmurf(Hero smurf) {
        Smurf = smurf;
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }
}
