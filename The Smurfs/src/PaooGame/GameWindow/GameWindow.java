package PaooGame.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GameWindow {
    private JFrame gamewindow; // fereastra principala a jocului
    private String gametitle; //titlul jocului
    private int gameWidth; //latimea ferestrei
    private int gameHeight; //inaltimea ferestrei

    private Canvas canvas;  /*!< "panza/tablou" in care se poate desena*/

    public GameWindow(String title, int width, int height){
        gametitle = title;
        gameWidth = width;
        gameHeight = height;
        gamewindow = null;
    }

    public void BuildGameWindow() {
        if(gamewindow != null)
        {
            return;
        }

        gamewindow=new JFrame(gametitle);
        gamewindow.setSize(gameWidth, gameHeight);
        gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamewindow.setResizable(false);
        gamewindow.setLocationRelativeTo(null);
        gamewindow.setVisible(true);

        gamewindow.setFocusable(true);
        if(gamewindow.isVisible())
        {
            gamewindow.requestFocusInWindow();
        }

        /// Creaza obiectul de tip canvas (panza) pe care se poate desena.
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(gameWidth, gameHeight));

        canvas.setMaximumSize(new Dimension(gameWidth, gameHeight));
        canvas.setMinimumSize(new Dimension(gameWidth, gameHeight));

        /// Avand in vedere ca obiectul de tip canvas, proaspat creat, nu este automat
        /// adaugat in fereastra trebuie apelata metoda add a obiectul wndFrame
        gamewindow.add(canvas);

        /// Urmatorul apel de functie are ca scop eventuala redimensionare a ferestrei
        /// ca tot ce contine sa poate fi afisat complet
        gamewindow.pack();
    }

    public int getGameHeight() {
        return gameHeight;
    }

    public int getGameWidth()
    {
        return gameWidth;
    }

    public Canvas GetCanvas()
    {
        return canvas;
    }

    public JFrame GetWindowFrame()
    {
        return gamewindow;
    }


}
