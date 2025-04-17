package greed;
import mvc.*;
import plague.PlagueSimulation;

public class GreedCommand extends Command {
    public GreedCommand(Model m) {super(m); }

    @Override
    public void execute() {
        String input = Utilities.ask("Enter the Amount Cows will Eat (0-100):");
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 100) throw new NumberFormatException();
            Cow.setGreedy(value);
            model.changed();
        } catch (NumberFormatException e) {
            Utilities.error("Enter number between 0 and 100");
        }
    }
}
