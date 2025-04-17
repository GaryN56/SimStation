package greed;
import simstation.*;

public class Cow extends MobileAgent {
    public int energy;
    public static int GREEDINESS = 25;
    public boolean alive;
    public Patch location;

    public Cow() {
        energy = 100;
        alive = true;
    }

    public void setDead() {
        this.alive = false;
        stop();
    }

    public static void setGreedy(int amt) {
        GREEDINESS = amt;
    }

    public boolean isAlive() {
        return alive;
    }
    public void waitForGrass() {
        energy -= Meadow.waitPenalty;
        if (energy <= 0) this.setDead();
    }

    public void gainEnergy(int amt) {
        energy = Math.min(100, energy + amt);
    }
    @Override
    public void update() {
        if (energy <= 0) {
            this.setDead();
            stop();
        }
        Meadow meadow = (Meadow) world;
        location = meadow.getPatch(xc, yc);

        if (location.getEnergy() >= GREEDINESS) {         // Patch has enough energy to eat
            location.eatMe(this, GREEDINESS);
        } else if (energy >= Meadow.moveEnergy) {     // Patch doesn't have enough energy, Cow has enough energy to move
            energy -= Meadow.moveEnergy;
            heading = Heading.random();
            move(Patch.PATCH_SIZE);
        } else {                                     // Patch and cow have no energy. Cow will wait
            location.eatMe(this, GREEDINESS);
        }
    }
}
