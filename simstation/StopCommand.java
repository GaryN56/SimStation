package simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

import javax.swing.*;

public class StopCommand extends Command {
    public StopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        try {
            ((World) model).stopAgents();
        } catch (Exception e) {
            Utilities.error(e.getMessage());
        }
    }
}
