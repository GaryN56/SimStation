package simstation.prisonersDilemma;

import mvc.AppPanel;
import simstation.Agent;
import simstation.ObserverAgent;
import simstation.World;
import simstation.WorldPanel;

import java.util.Random;

public class PrisonersDilemma extends World {
    private double cheaterTotal = 0;
    private double cooperatorTotal = 0;
    private double reciprocatorTotal = 0;
    private double randomTotal = 0;
    public void populate() {
        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner(new Cheat()));
        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner(new Cooperate()));
        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner(new RandomlyCooperate()));
        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner(new Tit4Tat()));
    }

    public String getStatus() {
        return ("#agents " + agents.size()
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
