package simstation;
import mvc.*;

public class StatsCommand extends Command {
    public StatsCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        World world = (World) this.model;
        Utilities.inform(world.getStatus());
    }
}
