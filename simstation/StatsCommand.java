package simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

import javax.swing.*;

public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        try {
            JOptionPane.showMessageDialog(null, ((World) model).getStatus());
        } catch (Exception e) {
            Utilities.error(e.getMessage());
        }
    }
}
