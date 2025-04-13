package simstation;

import mvc.*;

public class ResumeCommand extends Command {
    private Heading heading;
    private MobileAgent mobileAgent;
    private int steps;

    public ResumeCommand(MobileAgent mobileAgent, Heading heading, int steps) {
        super(mobileAgent.world);
        this.mobileAgent = mobileAgent;
        this.heading = heading;
        this.steps = steps;
    }

    @Override
    public void execute() throws Exception {
        try {
            mobileAgent.move(steps);
        } catch (Exception e) {
            Utilities.error(e.getMessage());
        }
    }
}
