package plague;
import mvc.*;

public class InitialInfectedCommand extends Command {
    public InitialInfectedCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        String input = Utilities.ask("Enter % of population initially infected (0-100): ");
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 100) throw new NumberFormatException();
            PlagueSimulation.setInitialInfected(value);
            model.changed();
        } catch (NumberFormatException e) {
            Utilities.error("Enter number between 0 and 100");
        }
    }
}
