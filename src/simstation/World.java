package simstation;

import mvc.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class World extends Model {
    public List<Agent> agents = new ArrayList<>();
    public static final int SIZE = 500;
    public static int CLOCK = 0;
    public int alive = 0;

    public void addAgent(Agent a) {
        agents.add(a);
        alive++;

        a.setWorld(this);
        a.setXc(Utilities.rng.nextInt(SIZE));
        a.setYc(Utilities.rng.nextInt(SIZE));
    }

    //Method to reset world when calling start()
    public void reset() {
        stopAgents();           // Make sure all threads are stopped
        agents.clear();         // Clear the current list of agents
        CLOCK = 0;              // Reset clock to 0
        alive = 0;              // Reset alive counter to 0
    }

    public void startAgents() {
        reset();
        populate();                         // Populate with new agents
        ObserverAgent o = new ObserverAgent();  // Make a new ObserverAgent
        agents.add(o);    // Add ObserverAgent to keep tabs on world
        o.setWorld(this);

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
        // Subtract ObserverAgent from the amount of total agents
        int mobileAgentsAmount = agents.size() - 1;
        return ("Clock: " + CLOCK + " Alive Agents: " + alive + " Total Agents: " + mobileAgentsAmount);
    }

    public void updateStatistics() {
        CLOCK++;
    }

    public Agent getNeighbor(Agent a, int radius) {
        for (Agent other : agents) {
            if (other != a && other instanceof MobileAgent) {
                double dx = other.getXc() - a.getXc();
                double dy = other.getYc() - a.getYc();
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance < radius) {
                    return other;
                }
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
