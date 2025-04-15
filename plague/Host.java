package plague;
import mvc.*;
import simstation.*;
public class Host extends MobileAgent {
    private boolean infected;
    private boolean alive;
    private int timeInfected;

    public Host() {
        infected = false;
        alive = true;
        timeInfected = 0;
    }



    public void setInfected(boolean infected) {
        this.infected = infected;
    }
    public boolean isInfected() {
        return this.infected;
    }
    public void setDead() { this.alive = false; }
    public boolean isAlive() { return this.alive; }

    // If host is infected, it will try to infect its neighbor
    public void infect() {
        Host partner = (Host) world.getNeighbor(this,10);
        if (this.isInfected() && !partner.isInfected()) {       // If this agent is infected and partner is not infected
            int luck = Utilities.rng.nextInt(100);       // Get a random integer 0-100
            if (luck <= PlagueSimulation.VIRULENCE) {           // If random integer is less than the chance of getting infected
                luck = Utilities.rng.nextInt(100);        // Roll for another random integer
                if (luck > PlagueSimulation.RESISTANCE) {       // If roll is greater than resistance %, infect them
                    partner.setInfected(true);
                }
            }
        }
    }


    @Override
    public void update() {
        if (this.isAlive()) {
            // If infected, will try to infect neighbor. Does nothing if host is not infected
            this.infect();

            int time = World.CLOCK - timeInfected;

            if (time >= PlagueSimulation.INFECTION_LENGTH) {
                if (PlagueSimulation.FATAL) {
                    this.setDead();
                } else {
                    this.setInfected(false);
                }
            }

            heading = Heading.random();
            move(3);
        }
    }
}
