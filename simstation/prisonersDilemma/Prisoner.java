package simstation.prisonersDilemma;

import mvc.Utilities;
import simstation.*;

public class Prisoner extends MobileAgent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strategy;

    public Prisoner() {
        super();
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);

        Agent neighbor = world.getNeighbor(this, 10);
        if(neighbor instanceof Prisoner partner) {
            boolean p1 = cooperate();
            boolean p2 = partner.cooperate();

            if(!p1 && p2) {
                // partner cooperate, this cheat
                updateFitness(5);
            } else if(p1 && !p2) {
                // partner cheat, this cooperate
                partner.updateFitness(5);
            } else if(p1 && p2) {
                // both cooperate
                updateFitness(3);
                partner.updateFitness(3);
            } else if(!p1 && !p2) {
                // both cheat
                updateFitness(1);
                partner.updateFitness(1);
            }

            if(!p2) partnerCheated = true;
            if(!p1) partner.partnerCheated = true;

            // above code is better for scalability
//            if (strategy instanceof Tit4Tat) {
//                ((Tit4Tat) strategy).updateOpponentCheated(p2);
//            }
//            if (partner.getStrategy() instanceof Tit4Tat) {
//                ((Tit4Tat) partner.getStrategy()).updateOpponentCheated(p1);
//            }
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

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean getPartnerCheated() {
        return partnerCheated;
    }
}