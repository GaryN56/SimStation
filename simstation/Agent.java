package simstation;

import java.io.Serializable;

abstract class Agent implements Runnable, Serializable {
    World world;
    private int xc;         // >= 0
    private int yc;         // <= world size
    private boolean paused = true;
    private boolean stopped = false;
    private String agentName;
    private Thread myThread;

    abstract void start();
    abstract void stop();
    abstract void pause();
    abstract void resume();
    void update() {
        Agent other = world.getNeighbor(this, 100);
        facilitator.send(other, new Message("name?"));
        Thread.sleep(1000);
        Message msg = mailBox.poll();
        facilitator.send(other, new Message("hello " + msg.content));
    }
    abstract boolean done();
    public void run() {
        while(!done()) {
            update();
            Thread.yield();
        }
    }
}