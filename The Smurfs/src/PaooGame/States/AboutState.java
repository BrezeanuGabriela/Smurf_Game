package PaooGame.States;

import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AboutState extends State{
    private BufferedImage background;
    public AboutState(RefLinks refLink) {
        super(refLink);
        background= ImageLoader.LoadImage("res/textures/about-background3.png");
    }

    @Override
    public void Update() {
        if(refLink.GetKeyManager().tasta_back)
            State.SetState(refLink.GetGame().menuState);
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(background,0,0,null);
        Font myFont=new Font("Serif",Font.BOLD,16);
        g.setFont(myFont);
        g.drawString("Povestea jocului:",30,20);
        g.drawString("Jocul este situat undeva între 2 lumi, între forța binelui și a răului. ",30,50);
        g.drawString("În satul Ștrumfilor firul vieții decurgea normal, până într-o zi când Ștrumfița a fost răpită de către",30,70);
        g.drawString("Gargamel în satul său. Acesta a încuiat-o într-o colivie pentru a fi sigur că nu poate evada.",30,90);
        g.drawString("Gargamel avea nevoie de firele de păr și de sângele albastru al strumfitei pentru a realiza o vrajă ce",30,110);
        g.drawString("urma să îi transforme pe ștrumfi în aur, astfel viața din satul lor dispărând complet. ",30,130);
        g.drawString("Puterile lui Papa Ștrumf erau limitate de înaintarea în vârstă, în consecință îl va trimite pe Ștrumful",30,170);
        g.drawString("Ucenic într-o călătorie lungă, întortocheată, fără a avea siguranță de reușită, în satul lui Gargamel",30,190);
        g.drawString("pentru a o salva pe Ștrumfița, implicit pe toată civilizația lor.",30,210);
        g.drawString("Singura putere a personajului(Ștrumful ucenic) este formată din intuiția jucătorului de a găsi",30,250);
        g.drawString("cât mai repede drumul corect.",30,270);
        g.drawString("Motanul lui Gargamel fiind supărat pe stăpânul său pentru că nu i-a mai oferit afecțiune în ultimul",30,310);
        g.drawString("timp hotărăște să îi strice planurile acestuia. Astfel dacă Ștrumful Ucenic îi va aduce 3 mere,",30,330);
        g.drawString("atunci acesta îi va oferi cheia de la colivia Ștrumfiței în schimb.",30,350);

        g.drawString("Instructiuni: ",30,410);
        g.drawString("Mers la dreapta - tasta dreapta", 30, 430);
        g.drawString("Mers la stanga - tasta stanga", 30, 450);
        g.drawString("Mers in sus - tasta sus", 30, 470);
        g.drawString("Mers in jos - tasta jos", 30, 490);

        g.drawString("Intoarcere la meniul principal - tasta Esc", 300, 430);
        g.drawString("Play din meniul principal - tasta Space", 300, 450);
        g.drawString("About din meniul principal - tasta A", 300, 470);

        g.drawString("In meniul principal se poate folosi mouse-ul, in rest nu.", 300, 510);
    }
}
