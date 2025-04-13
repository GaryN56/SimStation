package simstation;

import mvc.*;

public class ResumeCommand extends Command {
    private MobileAgent mobileAgent;
    private int steps;

    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        try {
            ((World) model).resumeAgents();
        } catch (Exception e) {
            Utilities.error(e.getMessage());
        }
    }
}
