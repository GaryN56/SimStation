package plague;
import mvc.*;
import simstation.*;

public class PlagueSimulation extends World {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int POPULATIONSIZE = 50;

    @Override
    public void populate() {
        for (int i = 0; i < POPULATIONSIZE; i++) {
            addAgent(new Host());
        }
    }
}
