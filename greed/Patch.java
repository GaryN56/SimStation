package greed;
import simstation.*;

public class Patch extends Agent{
    public int energy = 100;
    public static int GROWTH_RATE = 1;
    public static int PATCH_SIZE = 10;

    public int getEnergy() {
        return energy;
    }
    public synchronized void eatMe(Cow c, int amt) {
        while (energy < amt) {
            c.waitForGrass();
            try{
                wait();
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
        energy -= amt;
        c.gainEnergy(amt);
    }
    @Override
    public synchronized void update() {
        energy = Math.min(100, energy + GROWTH_RATE);
        notifyAll();
    }
}
