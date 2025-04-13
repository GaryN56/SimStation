package simstation;

import mvc.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class World extends Model {
    private List<Agent> agents = new ArrayList<>();
    private final int SIZE = 500;
    private int alive = 0;

    public World() {

    }

    public void addAgent(Agent a) {
        agents.add(a);
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
        return "";
    }

    public void updateStatistics() {

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
