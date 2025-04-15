package plague;
import mvc.*;

public class ProbabilityCommand extends Command {
    public ProbabilityCommand(Model m) {
        super(m);
    }
    @Override
    public void execute() {
        String input = Utilities.ask("Enter probability of getting infected (0-100): ");
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 100) throw new NumberFormatException();
            PlagueSimulation.setVirulence(value);
        } catch (NumberFormatException e) {
            Utilities.error("Enter number between 0 and 100");
        }
    }
}
