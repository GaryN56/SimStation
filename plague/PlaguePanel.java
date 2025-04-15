package plague;
import mvc.AppPanel;
import simstation.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlaguePanel extends WorldPanel {
    public PlaguePanel(WorldFactory factory) {
        super(factory);

    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PlagueFactory());
        panel.display();
    }
}
