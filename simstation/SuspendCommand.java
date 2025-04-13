package simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

import javax.swing.*;

public class SuspendCommand extends Command {

    public SuspendCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        try {
            ((World) model).pauseAgents();
        } catch (Exception e) {
            Utilities.error(e.getMessage());
        }
    }
}
