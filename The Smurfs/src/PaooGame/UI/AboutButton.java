package PaooGame.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class AboutButton extends  UIObject{
    private BufferedImage img;

    public AboutButton(float x, float y, int width, int height, BufferedImage image) {
        super(x, y, width, height);
        this.img=image;
    }

    @Override
    public void Update() {
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(img,(int)x,(int)y,width,height,null);
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }
}
