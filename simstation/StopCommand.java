package simstation;
import mvc.*;

public class StopCommand extends Command {
    public StopCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        World world = (World) this.model;
        world.stopAgents();
    }
}
