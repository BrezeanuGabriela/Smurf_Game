package PaooGame.States;

import PaooGame.Items.Apple;
import PaooGame.Items.EntityManager;
import PaooGame.Items.Hero;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;

import java.awt.*;

public class PlayState2 extends State{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    private Apple apple;
    private EntityManager entityManager;

    public PlayState2(RefLinks refLink) {
        super(refLink);
        map = new Map(refLink, "src/PaooGame/Maps/maplevel2.txt");
        refLink.SetMap(map);
        this.hero=refLink.GetGame().getPlayState().getEntityManager().GetHero();
        System.out.println(refLink.GetGame().getPlayState().getEntityManager().getItems().size());
        this.entityManager=refLink.GetGame().getPlayState().getEntityManager();
        System.out.println("s-a creat level 2");
    }

    @Override
    public void Update() {
        //hero.Update();
        //System.out.println("update level 2");
        map.Update();
        entityManager.Update();
    }

    @Override
    public void Draw(Graphics g) {
        //System.out.println("draw level 2");
        map.Draw(g);
        entityManager.Draw(g);
        //g.clearRect(0,0, refLink.GetGame().getGamewindow().getGameWidth(),
        //        refLink.GetGame().getGamewindow().getGameHeight());
       // g.setColor(Color.CYAN);
       // g.drawRect(0,0,720,620);
    }

    public Map getMap()
    {
        return map;
    }
}
