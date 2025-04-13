package simstation;

import mvc.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class World extends Model {
    private List<Agent> agents = new ArrayList<>();
    protected static final int SIZE = 500;
    private int alive = 0;

    public World() {
        populate();
    }

    public void addAgent(Agent a) {
        agents.add(a);
    }

    public void startAgents() {
        populate();
        for(Agent a : agents) {
            Thread thread = new Thread(a);
            thread.start();
            a.start();
        }
    }

    public void stopAgents() {
        for(Agent a : agents) {
            a.stop();
        }
    }

    public void pauseAgents() {
        for(Agent a : agents) {
            a.pause();
        }
    }

    public void resumeAgents() {
        for(Agent a : agents) {
            a.resume();
        }
    }

    public abstract void populate();

    public String getStatus() { // need to fix, should say if agent is alive or dead
        return "#agents = " + agents.size() + "\nliving = " + alive;
    }

    public void updateStatistics() { // this one should be the one that updates the stats menu popup

    }

    public List<Agent> getAgents() {
        return agents;
    }

    public Agent getNeighbor(Agent a, int radius) {
        for(Agent other : agents) {
            if(Math.abs(other.getXc() - a.getXc()) < radius || Math.abs(other.getYc() - a.getYc()) < radius) {
                return other;
            }
        }
        return null;
    }

    // required for w.iterator() in worldpanel to work
    // diagram on hw page doesnt have this
    public Iterator<Agent> iterator() {
        return agents.iterator();
    }

    public int getSize() {
        return SIZE;
    }
}
