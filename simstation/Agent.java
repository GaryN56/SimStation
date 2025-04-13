package simstation;

import java.io.Serializable;

abstract class Agent implements Runnable, Serializable {
    protected World world;
    private int xc;         // >= 0
    private int yc;         // <= world size
    private boolean paused = true;
    private boolean stopped = false;
    private String agentName;
    private Thread myThread;

    public void start() {
        paused = false;
        stopped = false;
        run();
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
    public boolean done() {
        return stopped;
    }
    public void run() {
        while(!done()) {
            update();
            Thread.yield();
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