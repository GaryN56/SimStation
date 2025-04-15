package plague;
import mvc.*;
import simstation.*;

public class PlagueSimulation extends World {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int POPULATION_SIZE = 50;  // size of population
    public static int INITIAL_INFECTED = 5; // % infected initially

    public static boolean FATAL = false;    // if virus is fatal or not
    public static int INFECTION_LENGTH = 200;    // Length of time to recover or die from virus

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
    public String getStatus() {
        return "Temp";
    }
}
