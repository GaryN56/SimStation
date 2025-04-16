package simstation.prisonersDilemma;

import mvc.Model;
import simstation.WorldFactory;

public class PrisonersDilemmaFactory extends WorldFactory {
    public Model makeModel() {
        return new PrisonersDilemma();
    }

    public String getTitle() { return "Prisoner's Dilemma";}

    public String[] getHelp() {
        return new String[] {"Prisoners use one of four strategies: Cheat, Cooperate, Random, and Tit4Tat", "Start button starts the simulation", "Suspend pauses the simulation",
                "Resume will continue the simulation if it was suspended", "Stop will stop the simulation and it cannot be resumed",
                "Stats shows the number of agents, clock time, and score of each prisoner's strategy"};
    }

    @Override
    public String about() { return "Prisoner's Dilemma 2025. CS151 Group 6";}
}
