package simstation.prisonersDilemma;

import mvc.Utilities;
import simstation.*;

class Prisoner extends MobileAgent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strategy;

    public Prisoner(Strategy strategy) {
        super();
        this.strategy = strategy;
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);

        if(world.getNeighbor(this, 10) != null) {
            Prisoner partner = (Prisoner) world.getNeighbor(this, 10);
            if (!partner.cooperate()) partnerCheated = true;

            if(!partnerCheated && !cooperate()) {
                // partner not cheat, this cheat
                updateFitness(5);
            } else if(!partnerCheated && cooperate()) {
                // both cooperate
                updateFitness(3);
                partner.updateFitness(3);
            } else if(partnerCheated && cooperate()) {
                // partner cheat, this cooperate
                partner.updateFitness(5);
            } else if(partnerCheated && !cooperate()) {
                // both cheat
                updateFitness(1);
                partner.updateFitness(1);
            }
        }
    }

    public void updateFitness(int amt) {
        fitness += amt;
    }

    public int getFitness() {
        return fitness;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}