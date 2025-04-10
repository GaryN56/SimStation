package simstation;

import mvc.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World extends Model {
    private List<Agent> agents = new ArrayList<>();
    private final int SIZE = 500;
    private int alive = 0;

    public World() {

    }

    public void addAgent(Agent a) {
        agents.add(a);
    }

    public void startAgents() {
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

    public void populate() {

    }

    public String getStatus() {

    }

    public void updateStatistics() {

    }

    public Agent getNeighbor(Agent a, int radius) {

    }

    // required for w.iterator() in worldpanel to work
    // diagram on hw page doesnt have this
    public Iterator<Agent> iterator() {
        return agents.iterator();
    }
}
