package simstation;

import mvc.*;
import java.awt.*;

public class WorldView extends View {
    public WorldView(Model m) {
        super(m);
    }


    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        World world = (World) model;

        for (Agent a : world.agents) {
            drawAgent(a, gc);
        }
    }

    public void drawAgent(Agent a, Graphics gc) {
        gc.setColor(Color.RED);
        gc.fillOval(a.xc - 5, a.yc - 5, 10, 10);
    }
}
