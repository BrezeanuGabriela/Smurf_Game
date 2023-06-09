package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.PlayState2;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

public abstract class Character extends Item
{
    public static final int DEFAULT_LIFE            = 5;
    public static final float DEFAULT_SPEED         = 2.6f;//5f;//2.6f;
    public static final int DEFAULT_CREATURE_WIDTH  = 21;
    public static final int DEFAULT_CREATURE_HEIGHT = 21;

    protected float speed;
    protected float xMove;
    protected float yMove;

    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
        //constructorul din item
        super(refLink, x,y, width, height);
        //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        life    = DEFAULT_LIFE;
        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
    }

    public void Move()
    {
        MoveX();
        MoveY();

        //pentru trecerea la nivelul urmator
        /*
        if(x>=700 &&y>=580 &&State.GetState()==refLink.GetGame().playState)
        {

            State.SetState(refLink.GetGame().playState2);
            System.out.println("level 1-2");
        }

         */

    }

    public void MoveX()
    {
        //eroul se misca la dreapta
        if(xMove>0)
        {
            //calculam coordanata x de intersectie a dalei din partea dreapta a eroului
            //x+xMove=coordonata x la care ar trebui sa fie eroul daca ar fi permisa deplasarea la dreapta
            //+bounds.x+bounds.width =>am adunat coordonata curenta x a dreptunghiului de coliziune al eroului
            //cu latimea dreptunghiului
            //in acest mod am obtinut coordonata x a dalei din partea dreapta a eroului pe care ar trebui sa se deplaseze
            int tilex=(int)(x+xMove+ bounds.x+bounds.width)/ Tile.TILE_WIDTH;

            //verificam coliziunile
            if(!collisionWithTile(tilex, (int)(y+bounds.y)/Tile.TILE_HEIGHT) && //coltul dreapta sus
                    !collisionWithTile(tilex,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) //coltul dreapta jos
                    && !checkItemCollisions()) //verificare coliziune cu vreun mar
                //daca nu exista coliziune cu vreo dala sau cu vreun mar, eroul se deplaseaza normal
            {
                if(x+xMove<=700) //daca x+xmove nu depaseste latimea ferestrei
                    x+=xMove;
                else  //altfel vom pozitiona eroul pe dala de langa extremitatea dreapta, coordonata y ramanand aceeasi
                {
                    //x=700;
                    //if(x>=700 &&y>=580 &&State.GetState()==refLink.GetGame().playState)
//                    {
                    if (refLink.GetGame().level2creat == false) {
                        refLink.GetGame().level2creat=true;
                        refLink.GetGame().playState2 = new PlayState2(refLink);
                        State.SetState(refLink.GetGame().playState2);
                        x=224;
                        y=0;
                    }
                    else
                    {
                        State.SetState(refLink.GetGame().playState2);
                        x=224;
                        y=0;
                        refLink.SetMap(refLink.GetGame().getPlayState2().getMap());
                    }
                        //System.out.println("level 1-2");
                }
            }
            else if(!collisionWithTile(tilex, (int)(y+bounds.y)/Tile.TILE_HEIGHT) &&//coltul dreapta sus
                    !collisionWithTile(tilex,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)&&//coltul dreapta jos
                    checkItemCollisions())//verificare coliziune cu vreun mar
                //nu exista coliziune cu vreo dala, dar exista cu un mar
            {
                System.out.println(refLink.getPlayState().getEntityManager().getItems().size());
                //verificam cu care mar a avut coliziune pentru a-l putea indeparta de pe harta si aduna la scor
                for(Item item: refLink.getPlayState().getEntityManager().getItems())
                    if(item.collision==true)
                    {
                        item.decreaseLife(1); //apelam functia care va scadea "viata" marului pentru a-l indeparta
                    }
            }
            else //exista coliziune cu dala din dreapta
            {
                x=tilex*Tile.TILE_WIDTH- bounds.x- bounds.width-1; //pozitionam eroul langa dala pe care nu are voie sa mearga
                //scadem 1 pixel pentru a nu ramane blocat in coliziune
            }
        }
        //eroul se misca la stanga
        else if(xMove<0)
        {
            //calculam coordanata x  de intersectie a dalei din partea stanga a eroului
            //x+xMove=coordonata x la care ar trebui sa fie eroul daca ar fi permisa deplasarea la stanga
            //+bounds.x => am adunat coordonata curenta x a dreptunghiului de coliziune al eroului
            //in acest mod am obtinut coordonata x a dalei din partea stanga a eroului pe care ar trebui sa se deplaseze
            int tilex=(int)(x+xMove+bounds.x)/ Tile.TILE_WIDTH;

            if(!collisionWithTile(tilex, (int)(y+bounds.y)/Tile.TILE_HEIGHT) && //coltul stang sus
                    !collisionWithTile(tilex,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) //coltul stang jos
                    && !checkItemCollisions()) //verificam coliziunea cu marul
            {
                x+=xMove;
            }
            else if(!collisionWithTile(tilex, (int)(y+bounds.y)/Tile.TILE_HEIGHT) && //coltul stang sus
                !collisionWithTile(tilex,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) //coltul stang jos
                && checkItemCollisions()) //verificam coliziunea cu marul
            {
                //verificam cu care mar a avut coliziune pentru a-l putea indeparta de pe harta si aduna la scor
                for(Item item: refLink.getPlayState().getEntityManager().getItems())
                    if(item.collision==true)
                        item.decreaseLife(1);
            }
            else //exista coliziune cu dala din stanga
            {
                x=tilex*Tile.TILE_WIDTH+Tile.TILE_WIDTH- bounds.x;//pozitionam eroul langa dala din stanga pe care nu are voie sa mearga
            }
        }
    }

    public void MoveY()
    {
        //deplasare in sus
        if(yMove<0)
        {
            //calculam coordanata y de intersectie cu dala din partea de sus a eroului
            //y+yMove=coordonata y la care ar trebui sa fie eroul daca ar fi permisa deplasarea in sus
            //+bounds.y => am adunat coordonata curenta y a dreptunghiului de coliziune al eroului
            //in acest mod am obtinut coordonata y(de jos) a dalei din partea de sus a eroului pe care ar trebui sa se deplaseze
            int ty=(int)(y+yMove+ bounds.y)/ Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && //colt stanga sus
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty) //colt dreapta sus
                    &&!checkItemCollisions()) //coliziune cu merele(functie din item)
            {
                if(y+yMove>=0)//pentru a nu parasi harta
                    y+=yMove;
                else if(State.GetState()==refLink.GetGame().playState2)
                {
                        State.SetState(refLink.GetGame().playState);
                        refLink.SetMap(refLink.getPlayState().getMap());
                        x=24;
                        y=0;
                }
                else {
                        y=0;
                }

            }
            else if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && //colt stanga sus
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty) //colt dreapta sus
                    &&checkItemCollisions()) //coliziune cu merele(functie din item)
            {
                //verificam cu care mar a avut coliziune pentru a-l putea indeparta de pe harta si aduna la scor
                for(Item item: refLink.getPlayState().getEntityManager().getItems())
                    if(item.collision==true)
                        item.decreaseLife(1);
            }
            else //exista coliziune cu dala din sus
            {
                y=ty*Tile.TILE_HEIGHT+Tile.TILE_HEIGHT- bounds.y;
            }
        }
        //deplasare in jos
        else if(yMove>0)
        {
            //calculam coordanata y de intersectie cu dala din partea de jos a eroului
            //y+yMove=coordonata y la care ar trebui sa fie eroul daca ar fi permisa deplasarea in jos
            //+bounds.y +bounds.height=> am adunat coordonata curenta y a dreptunghiului de coliziune al eroului
            //si inaltimea pentru a obtine coordonata y din partea de jos a dreptunghiului de coliziune
            //in acest mod am obtinut coordonata y(de sus) a dalei din partea de jos a eroului pe care ar trebui sa mearga
            int ty=(int)(y+yMove+ bounds.y+bounds.height)/ Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && //colt stanga jos
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty) //colt dreapta jos
                &&!checkItemCollisions()) //verificam coliziunea cu merele(functie din item)
            {
                y+=yMove;
            }
            else if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && //colt stanga jos
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty) //colt dreapta jos
                    &&checkItemCollisions()) //verificam coliziunea cu merele(functie din item)
            {
                //verificam cu care mar a avut coliziune pentru a-l putea indeparta de pe harta si aduna la scor
                for(Item item: refLink.getPlayState().getEntityManager().getItems())
                    if(item.collision==true)
                        item.decreaseLife(1);
            }
            else //exista coliziune cu dala
            {
                y=ty*Tile.TILE_HEIGHT-bounds.y- bounds.height-1;
            }
        }
    }

    //functie ce ne ajuta sa determinam coliziunea cu dalele
    public boolean collisionWithTile(int x, int y)
    {
        return refLink.GetMap().GetTile(x,y).IsSolid();
    }

    public int GetLife()
    {
        return life;
    }

    /*! \fn public int GetSpeed()
        \brief Returneaza viteza caracterului.
     */
    public float GetSpeed()
    {
        return speed;
    }

    /*! \fn public void SetLife(int life)
        \brief Seteaza viata caracterului.
     */
    public void SetLife(int life)
    {
        this.life = life;
    }

    /*! \fn public void SetSpeed(float speed)
        \brief
     */
    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public float GetXMove()
        \brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
     */
    public float GetXMove()
    {
        return xMove;
    }

    /*! \fn public float GetYMove()
        \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
     */
    public float GetYMove()
    {
        return yMove;
    }

    /*! \fn public void SetXMove(float xMove)
        \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
     */
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }

    /*! \fn public void SetYMove(float yMove)
        \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
     */
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }

    public void die()
    {
    }
}

