package plague;

import mvc.*;
import simstation.*;
import java.awt.*;

public class PlagueView extends WorldView {
    public PlagueView(Model m) { super(m); }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        PlagueSimulation plague = (PlagueSimulation) model;

        for (Agent a : plague.agents) {
            if (a instanceof Host) {
                drawHost((Host) a, gc);
            }
        }
    }
    public void drawHost(Host h, Graphics gc) {
        if (!h.isAlive()) {
            gc.setColor(Color.BLACK);
        } else if (h.isInfected()) {
            gc.setColor(Color.RED);
        } else {
            gc.setColor(Color.GREEN);
        }
        gc.fillOval(h.getXc() - 5, h.getYc() - 5, 10, 10);

    }
}
