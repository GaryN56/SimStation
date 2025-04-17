package prisonersDilemma;

import mvc.AppPanel;
import simstation.Agent;
import simstation.ObserverAgent;
import simstation.World;
import simstation.WorldPanel;

public class PrisonersDilemma extends World {
    private double cheaterTotal = 0;
    private double cooperatorTotal = 0;
    private double reciprocatorTotal = 0;
    private double randomTotal = 0;
    public void populate() {
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new Cheat(p));
            addAgent(p);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new Cooperate(p));
            addAgent(p);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new RandomlyCooperate(p));
            addAgent(p);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new Tit4Tat(p));
            addAgent(p);
        }
    }

    public void reset() {
        super.reset();
        cheaterTotal = 0;
        cooperatorTotal = 0;
        reciprocatorTotal = 0;
        randomTotal = 0;
    }

    public String getStatus() {
        return ("#agents " + (agents.size()-1) // subtract observer agent
                + "\nclock: " + CLOCK
                + "\nCheater's average: " + cheaterTotal/40.0
                + "\nCooperator's average: " + cooperatorTotal/40.0
                + "\nReciprocator's average: " + reciprocatorTotal/40.0
                + "\nRandom's average: " + randomTotal/40.0);
    }

    public void updateStatistics() {
        super.updateStatistics(); // update clock
        for(Agent a : agents) {
            if(a instanceof ObserverAgent) continue;
            Prisoner p = (Prisoner) a;
            int fitness = p.getFitness();
            if(p.getStrategy() instanceof Cheat) cheaterTotal += fitness;
            if(p.getStrategy() instanceof Cooperate) cooperatorTotal += fitness;
            if(p.getStrategy() instanceof Tit4Tat) reciprocatorTotal += fitness;
            if(p.getStrategy() instanceof RandomlyCooperate) randomTotal += fitness;
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PrisonersDilemmaFactory());
        panel.display();
    }
}
