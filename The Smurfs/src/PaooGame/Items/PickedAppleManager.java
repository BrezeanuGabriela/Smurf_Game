package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.States.State;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PickedAppleManager {
    private RefLinks refLinks;
    private ArrayList<Item> items; //un vector cu merele adunate
    private boolean displayed=false;

    public PickedAppleManager(RefLinks refLinks)
    {
        this.refLinks=refLinks;
        items=new ArrayList<Item>();
    }

    public void Update()
    {
        Iterator<Item> it=items.iterator();
        while(it.hasNext())
        {
            Item item=it.next();
            item.Update();
        }
        //pentru pop-ul cu mesaj
        if(displayed==false)
            if(items.size()==1)
        {
           // refLinks.getPlayState().displayPopup();
            displayed=true;
        }
    }

    public void Draw(Graphics g)
    {
        for(Item item: items)
        {
            item.Draw(g);
        }
    }

    public void addItem(Item item)
    {
        items.add(item);
        System.out.println(items.size());
    }

    public RefLinks getRefLinks()
    {
        return refLinks;
    }

    public int getSize()
    {
        return items.size();
    }
}
