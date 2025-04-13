package simstation;

import mvc.Utilities;

import java.io.Serializable;
import java.util.Random;

abstract class Agent implements Runnable, Serializable {
    protected World world;
    protected int xc;         // >= 0
    protected int yc;         // <= world size
    private boolean paused = false;
    private boolean stopped = false;
    private String agentName;
    transient protected Thread myThread;


    public Agent() {
        Random rand = new Random();
        this.xc = rand.nextInt(501);
        this.yc = rand.nextInt(501);
        System.out.println(xc + " " + yc);
        start();
    }

    public Agent(String name, int xc, int yc) {
        this.xc = xc;
        this.yc = yc;
        agentName = name;
    }

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
    public synchronized void update() {
        System.out.println("update");
        world.changed();
    }
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