package PaooGame.Maps;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Map
{
    private RefLinks refLink;
    private int width;          //Latimea hartii in numar de dale.
    private int height;         //Inaltimea hartii in numar de dale.
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    //in functie de codurile salvate in aceasta matrice, vom putea realiza coliziunile eroului cu harta,
    //dar si desenarea ei

    public Map(RefLinks refLink, String path)
    {
        this.refLink = refLink;
        LoadWorld(path); //se va incarca harta construita
    }

    public  void Update()
    {

    }

    public void Draw(Graphics g)
    {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }
    }

    //vom returna o referinta catre dala aferenta codului din matricea de dale de la coordonatele primite
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height) //coordonatele nu se incadreaza in dimensiunea hartii
        {
            return Tile.yellowTile; //by default, va fi o dala galbena(pe care poate merge personajul)
        }
        Tile t = Tile.tiles[tiles[x][y]];//obtinem dala corespunzatoare
        if(t == null) //in cazul in care este null
        {
            return Tile.grayTile; //returnam o dala gri(nu se poate merge pe ea)
        }
        return t; //returnam dala obtinuta
    }

    //generam harta
    //vom citi harta dintr-un fisier(maplevel1)
    private void LoadWorld(String path)
    {
        //citim din fisier toate detaliile necesare
      try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            // in fisier pe primul rand,nr coloane
            //al doilea rand, nr randuri
            width = Integer.parseInt(br.readLine());
            height = Integer.parseInt(br.readLine());
            tiles = new int[width][height];
            String delimeters = " "; //numerele in fisier sunt despartite prin spatiu
            String currentLine;

            for(int x=0; x<height; x++)
            {
                currentLine= br.readLine();
                String[] tokens = currentLine.split(delimeters);
                for(int y=0; y < width; y++)
                {
                    tiles[y][x] = Integer.parseInt(tokens[y]);
                }
            }
        }catch (Exception e) {
          e.printStackTrace();
      }
    }
}