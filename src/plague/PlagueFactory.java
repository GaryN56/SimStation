package plague;
import mvc.*;
import simstation.*;

public class PlagueFactory extends WorldFactory {
    @Override
    public Model makeModel() { return new PlagueSimulation(); }

    @Override
    public View makeView(Model model) {
        return new PlagueView(model);
    }
    @Override
    public String getTitle() { return "Plague"; }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Stop", "Suspend", "Resume", "Stats", "Initial % Infected",
        "Infection Probability", "Initial Population Size", "Fatality/Recovery Time", "Toggle Fatality"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return switch(type) {
            case "Start" -> new StartCommand(model);
            case "Stop" -> new StopCommand(model);
            case "Suspend" -> new SuspendCommand(model);
            case "Resume" -> new ResumeCommand(model);
            case "Stats" -> new StatsCommand(model);
            case "Initial % Infected" -> new InitialInfectedCommand(model);
            case "Infection Probability" -> new ProbabilityCommand(model);
            case "Initial Population Size" -> new InitialPopulationCommand(model);
            case "Fatality/Recovery Time" -> new TimeCommand(model);
            case "Toggle Fatality" -> new ToggleCommand(model);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Set the initial % of the population infected", "Set the % chance of an agent getting infected",
        "Set the initial population size", "Set how long an agent should be infected before they die or recover",
        "Set if the virus is fatal or not", "Start to start a new simulation", "Stop to stop the simulation",
        "Suspend to pause the simulation", "Resume to resume simulation after pausing",
        "Stats to see time, # of agents, # of alive, # of infected, and # of dead"};
    }

    @Override
    public String about() { return "Plague 2025. CS151 Group 5";}
}
