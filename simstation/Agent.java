package simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    protected World world;
    protected int xc;         // >= 0
    protected int yc;         // <= world size
    protected boolean paused = false;
    protected boolean stopped = false;
    protected String agentName;
    transient protected Thread myThread;


    public void setWorld(World w) {
        this.world = w;
    }
    public void start() {
        paused = false;
        stopped = false;
        myThread = new Thread(this);
        myThread.start();
    }
    public void stop() {
        stopped = true;
    }
    public void pause() {
        paused = true;
    }
    public void resume() {
        paused = false;
    }
    abstract void update(); // override this
    protected void onStart() {}
    protected void onInterrupted() {}
    public void onExit() {}
    public boolean done() {
        return stopped;
    }
    public void run() {
        onStart();
        try {
            while (!stopped) {
                if (!paused) {
                    update();
                    world.changed();
                    Thread.sleep(20);
                } else {
                    Thread.sleep(20);
                }
            }
        } catch (InterruptedException e) {
            onInterrupted();
        } finally {
            onExit();
        }
    }


    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }

    public void setXc(int xc) {
        this.xc = xc;
    }

    public void setYc(int yc) {
        this.yc = yc;
    }
}