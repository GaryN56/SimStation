package simstation;

import mvc.*;

public class ResumeCommand extends Command {
    public ResumeCommand(Model m) {
        super(m);
    }

    @Override
    public void execute() {
        World world = (World) this.model;
        world.resumeAgents();
    }
}
