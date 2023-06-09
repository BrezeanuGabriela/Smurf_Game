package PaooGame.Input;

import PaooGame.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
    private boolean leftPressed;
    private boolean rightPressed;
    private int mouseX;
    private int mouseY;

    private UIManager uiManager;

    public MouseManager()
    {
        leftPressed=false;
        rightPressed=false;
    }

    public void setUiManager(UIManager uiManager)
    {
        this.uiManager=uiManager;
    }

    public boolean isLeftPressed()
    {
        return leftPressed;
    }

    public boolean isRightPressed()
    {
        return rightPressed;
    }

    public int getMouseX()
    {
        return mouseX;
    }

    public int getMouseY()
    {
        return mouseY;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)//butonul din stanga
            leftPressed=true;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPressed=true;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)//butonul din stanga
            leftPressed=false;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPressed=false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

}

