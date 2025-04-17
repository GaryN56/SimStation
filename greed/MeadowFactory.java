package greed;
import mvc.*;
import plague.*;
import simstation.*;

public class MeadowFactory extends WorldFactory {
    @Override
    public Model makeModel() { return new Meadow(); }

    @Override
    public View makeView(Model model) {
        return new MeadowView(model);
    }

    @Override
    public String getTitle() { return "Greed"; }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Stop", "Suspend", "Resume", "Stats", "Greed", "Grow Back Rate",
        "Move Energy"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return switch(type) {
            case "Start" -> new StartCommand(model);
            case "Stop" -> new StopCommand(model);
            case "Suspend" -> new SuspendCommand(model);
            case "Resume" -> new ResumeCommand(model);
            case "Stats" -> new StatsCommand(model);
            case "Greed" -> new GreedCommand(model);
            case "Grow Back Rate" -> new GrowBackCommand(model);
            case "Move Energy" -> new MoveEnergyCommand(model);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Greed = How much cow attempts to eat each time",
                "Grow Back Rate: How fast patches grow back", "Move Energy = How much energy it takes to move"};
    }

    @Override
    public String about() {return "Greed 2025. CS151 Group 5";}
}
