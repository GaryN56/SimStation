package greed;
import simstation.*;

public class Cow extends MobileAgent {
    public int energy = 100;
    public static int GREEDINESS = 25;

    public Patch location;

    public void waitForGrass() {

    }


    public void gainEnergy(int amt) {
        energy = Math.min(100, energy + amt);
    }
    @Override
    public void update() {
        if (energy <= 0) {
            stop();
        }

    }
}
