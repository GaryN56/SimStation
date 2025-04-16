package simstation.prisonersDilemma;

import mvc.AppPanel;
import mvc.Model;
import simstation.WorldFactory;
import simstation.WorldPanel;

public class PrisonersDilemmaFactory extends WorldFactory {
    public Model makeModel() {
        return new PrisonersDilemma();
    }

    public String getTitle() { return "Prisoner's Dilemma";}
}
