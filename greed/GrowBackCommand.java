package greed;
import mvc.*;
import plague.PlagueSimulation;

public class GrowBackCommand extends Command {
    public GrowBackCommand(Model m) { super(m); }

    @Override
    public void execute() {
        String input = Utilities.ask("Enter New Growth Rate (0-10):");
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 10) throw new NumberFormatException();
            Patch.setGrowthRate(value);
            model.changed();
        } catch (NumberFormatException e) {
            Utilities.error("Enter number between 0 and 10");
        }
    }
}
