package PaooGame.Items;
import PaooGame.RefLinks;

import java.awt.*;


public abstract class Item  //definim notiunea de entitate din joc
{
    protected float x;
    protected float y;
    protected int width; //latimea imaginii corespunzatoare
    protected int height; //inaltimea imaginii corespunzatoare

    //dreptunghiuri de coliziune
    protected Rectangle bounds;
    protected Rectangle normalBounds;

    protected RefLinks refLink;

    protected int life=1; //fiecare item are o singura viata
    protected boolean active=true; //daca devine false, vom elimina item-ul

    protected boolean collision=false;

    public Item(RefLinks refLink, float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.refLink = refLink;

        normalBounds = new Rectangle(0, 0, width, height); //initial va fi de dimensiunea personajului,
        // dar dupa se poate modifica pentru fiecare entitate
        bounds = normalBounds;
    }

    public abstract void Update();
    public abstract void Draw(Graphics g);

    public void decreaseLife(int amount)
    {
        life=life-amount;
        if(life<=0)
        {
            active=false; //pt ca a devenit false, cand se face update in entity manager, se va elimina marul
            die();//functia care va hotari ce se va intampla cu entitatea dupa pierderea vietii
        }
    }

    public abstract void die(); //functia care va hotari ce se va intampla cu entitatea la finalul vietii

    public boolean getActive()
    {
        return active;
    }

    public float GetX()
    {
        return x;
    }

    public float GetY()
    {
        return y;
    }

    public int GetWidth()
    {
        return width;
    }

    public int GetHeight()
    {
        return height;
    }

    public void SetX(float x)
    {
        this.x = x;
    }

    public void SetY(float y)
    {
        this.y = y;
    }

    public void SetWidth(int width)
    {
        this.width = width;
    }

    public void SetHeight(int height)
    {
        this.height = height;
    }

    public void SetNormalMode()
    {
        bounds = normalBounds;
    }

    public int getLife()
    {
        return life;
    }


    public Rectangle getCollisionBounds()
    {
        return new Rectangle((int)(x+bounds.x),(int)(y+bounds.y),bounds.width,bounds.height);
    }

    public boolean checkItemCollisions() //coliziune erou cu entitatea mar
    {
        for(Item item: refLink.getPlayState().getEntityManager().getItems())
        {
            //evitam coliziunea cu sinele
            if(item.equals(refLink.GetGame().getPlayState().getEntityManager().GetHero()))
                continue;
            if(item.getCollisionBounds().intersects(this.getCollisionBounds()))
            {
                item.collision=true; //astfel vom depista pe care mar trebuie sa il eliminam
                return true;
            }
        }
        return false;
    }

    public void setRefLink(RefLinks refLinks)
    {
        this.refLink=refLinks;
    }

}
