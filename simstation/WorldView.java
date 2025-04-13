package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class WorldView extends View {
    World w;

    public WorldView(Model m) {
        super(m);
        w = (World) m;
        w.subscribe(this);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        for(Agent a : w.getAgents()) {
            drawAgent(a, gc);
        }
    }

    public void drawAgent(Agent a, Graphics gc) {
        gc.setColor(Color.red);
        gc.fillOval(a.getXc(), a.getYc(), 10, 10);
    }
}
