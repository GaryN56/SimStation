package plague;
import mvc.*;


public class ToggleCommand extends Command{
    public ToggleCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        PlagueSimulation.FATAL = !PlagueSimulation.FATAL;
        model.changed();
    }
}
