package simstation.prisonersDilemma;

import mvc.AppPanel;
import simstation.Agent;
import simstation.World;
import simstation.WorldPanel;

public class PrisonersDilemma extends World {
    private double cheaterAvg = 0;
    private double cooperatorAvg = 0;
    private double reciprocatorAvg = 0;
    private double randomAvg = 0;
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
                + "clock: " + CLOCK
                + "Cheater's average: " + cheaterAvg
                + "Cooperator's average: " + cooperatorAvg
                + "Reciprocator's average: " + reciprocatorAvg
                + "Random's average: " + randomAvg);
    }

    public void updateStatistics() {
        super.updateStatistics(); // update clock
        for(Agent a : agents) {
            int fitness = ((Prisoner) a).getFitness();
            if(((Prisoner) a).getStrategy().equals(new Cheat())) cheaterAvg += fitness / 40.0;
            if(((Prisoner) a).getStrategy().equals(new Cooperate())) cooperatorAvg += fitness / 40.0;
            if(((Prisoner) a).getStrategy().equals(new Tit4Tat())) reciprocatorAvg += fitness / 40.0;
            if(((Prisoner) a).getStrategy().equals(new RandomlyCooperate())) randomAvg += fitness / 40.0;
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PrisonersDilemmaFactory());
        panel.display();
    }
}
