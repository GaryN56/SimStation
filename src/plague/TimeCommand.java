package plague;
import mvc.*;

public class TimeCommand extends Command {
    public TimeCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        String input = Utilities.ask("Enter amount of time host should be infected for (0-500): ");
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 100) throw new NumberFormatException();
            PlagueSimulation.setInfectionLength(value);
            model.changed();
        } catch (NumberFormatException e) {
            Utilities.error("Enter number between 0 and 500");
        }
    }
}
