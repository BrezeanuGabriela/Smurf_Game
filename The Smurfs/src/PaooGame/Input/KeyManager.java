package PaooGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    private boolean[] keys; /*!< Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]*/
    public boolean up;      /*!< Flag pentru tasta "sus" apasata.*/
    public boolean down;    /*!< Flag pentru tasta "jos" apasata.*/
    public boolean left;    /*!< Flag pentru tasta "stanga" apasata.*/
    public boolean right;   /*!< Flag pentru tasta "dreapta" apasata.*/
    public boolean space;
    public boolean tasta_a;
    public boolean tasta_back;

    public KeyManager()
    {
        ///Constructie vector de flaguri aferente tastelor.
        keys = new boolean[256];
    }

    public void Update()
    {
        //System.out.println("update key");
        up    = keys[KeyEvent.VK_UP];
        down  = keys[KeyEvent.VK_DOWN];
        left  = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
        tasta_a=keys[KeyEvent.VK_A];
        tasta_back=keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
        //System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        ///se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
}
