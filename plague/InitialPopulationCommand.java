package plague;
import mvc.*;

public class InitialPopulationCommand extends Command {
    public InitialPopulationCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        String input = Utilities.ask("Enter Initial Population Size (0 - 200): ");
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 100) throw new NumberFormatException();
            PlagueSimulation.setPopulationSize(value);
            model.changed();
        } catch (NumberFormatException e) {
            Utilities.error("Enter number between 0 and 200");
        }
    }
}
