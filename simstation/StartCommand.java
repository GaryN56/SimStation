package simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class StartCommand extends Command {
    public StartCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        try {
            ((World) model).startAgents();
        } catch (Exception e) {
            Utilities.error(e.getMessage());
            throw new Exception(e);
        }
    }
}
