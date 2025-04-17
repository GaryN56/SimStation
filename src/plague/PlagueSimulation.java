package plague;
import mvc.*;
import simstation.*;

public class PlagueSimulation extends World {
    public static int VIRULENCE = 50; // % chance of infection
//    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int POPULATION_SIZE = 50;  // size of population
    public static int INITIAL_INFECTED = 30; // % infected initially

    public static boolean FATAL = false;    // if virus is fatal or not
    public static int INFECTION_LENGTH = 50;    // Length of time to recover or die from virus
    public int aliveAmount;
    public int deadAmount;
    public int infectedAmount;

    @Override
    public void populate() {
        int infectedCount = POPULATION_SIZE * INITIAL_INFECTED / 100;
        for (int i = 0; i < POPULATION_SIZE; i++) {
            Host h = new Host();
            if (i < infectedCount) { h.setInfected(true); }
            addAgent(h);
        }
    }
    public static void setInitialInfected(int input) { INITIAL_INFECTED = input; }

    public static void setVirulence(int input) { VIRULENCE = input; }

    public static void setPopulationSize(int input) { POPULATION_SIZE = input; }

    public static void setInfectionLength(int input) { INFECTION_LENGTH = input; }


    @Override
    public void updateStatistics() {
        super.updateStatistics();
        aliveAmount = 0;
        deadAmount = 0;
        infectedAmount = 0;
        for (Agent a : agents) {
            if (a instanceof Host h) {
                if (!h.isAlive()) {             //Increment dead counter if agent is dead
                    deadAmount++;
                } else if (h.isInfected()){     //Increment infected and alive counter if agent is infected
                    infectedAmount++;
                    aliveAmount++;
                } else {                        //Increment alive counter if alive and not infected
                    aliveAmount++;
                }
            }
        }

    }

    @Override
    public String getStatus() {
        int mobileAgentsAmount = agents.size() - 1;
        double percentInfected = ((double) infectedAmount / aliveAmount) * 100;
        return "# of Agents: " + mobileAgentsAmount + "\n Clock: " + CLOCK + "\n % infected: " + percentInfected
                + "\n Alive: " + aliveAmount + "\n Infected: " + infectedAmount + "\n Dead: " + deadAmount;
    }
}
