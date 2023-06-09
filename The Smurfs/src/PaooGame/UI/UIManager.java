package PaooGame.UI;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {

    private RefLinks refLinks;
    private ArrayList<UIObject> objects;

    public UIManager(RefLinks refLinks)
    {
        this.refLinks=refLinks;
        objects=new ArrayList<UIObject>();
    }

    public UIObject getObjectatIndex(int index)
    {
        return objects.get(index);
    }

    public void Update()
    {
        for(UIObject object: objects)
            object.Update();
    }
    public void Draw(Graphics g)
    {
        for(UIObject object: objects)
            object.Draw(g);
    }
/*
    public void onMouseMove(MouseEvent e)
    {
        for(UIObject object: objects)
            object.onMouseMove(e);
    }

    public void onMouseRelease(MouseEvent e)
    {
        for(UIObject object: objects)
            object.onMouseRelease(e);
    }


 */
    public void addObject(UIObject object)
    {
        objects.add(object);
    }

    public void removeObject(UIObject object)
    {
        objects.remove(object);
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
}
