package greed;
import mvc.*;
import plague.PlagueSimulation;

public class MoveEnergyCommand extends Command {
    public MoveEnergyCommand(Model m) { super(m); }

    @Override
    public void execute() {
        String input = Utilities.ask("Enter Amount of Energy to Move (0-50):");
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 50) throw new NumberFormatException();
            Meadow.setMoveEnergy(value);
            model.changed();
        } catch (NumberFormatException e) {
            Utilities.error("Enter number between 0 and 50");
        }
    }
}
