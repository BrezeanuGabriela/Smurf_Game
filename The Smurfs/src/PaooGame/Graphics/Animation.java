package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private BufferedImage[] frames;
    private int currentFrame;

    private long delay;
    private long startTime;

    public Animation()
    {
    }

    public void setDelay(long d)
    {
        delay=d;
    }

    public void setFrames(BufferedImage[] frames)
    {
        this.frames=frames;
        currentFrame=0;
        startTime=System.nanoTime();
    }

    public void update()
    {
        if(delay==-1)
            return;
        long timer=(System.nanoTime()-startTime)/1000000;
        if(timer>delay) {
            currentFrame++;
            startTime = System.nanoTime();
            if (currentFrame == frames.length ) {
                currentFrame = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame()
    {
        return frames[currentFrame];
    }
}
