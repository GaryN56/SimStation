package simstation;

import mvc.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class World extends Model {
    protected List<Agent> agents = new ArrayList<>();
    protected static final int SIZE = 500;
    protected int alive = 0;
    protected int clock = 0;

    public void addAgent(Agent a) {
        agents.add(a);
        alive++;
        a.setWorld(this);
        a.setXc(Utilities.rng.nextInt(SIZE));
        a.setYc(Utilities.rng.nextInt(SIZE));
    }

    public void startAgents() {
        populate();
        for(Agent a : agents) {
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

    public String getStatus() {
        return ("Clock: " + clock + " Alive Agents: " + alive + " Total Agents: " + agents.size());
    }

    public void updateStatistics() {
        clock++;

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
}
