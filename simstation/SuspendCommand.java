package simstation;
import mvc.*;

public class SuspendCommand extends Command {
    public SuspendCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        World world = (World) this.model;
        world.pauseAgents();
    }
}
