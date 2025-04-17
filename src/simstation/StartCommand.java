package simstation;
import mvc.*;

public class StartCommand extends Command{
    public StartCommand(Model m) {
        super(m);
    }
    @Override
    public void execute() {
        World world = (World) this.model;
        world.startAgents();
    }

}
