package PaooGame.UI;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle bounds;

    public UIObject(float x, float y, int width, int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds=new Rectangle((int)x, (int)y, width,height);
    }

    public abstract void Update();

    public abstract void Draw(Graphics g);

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
