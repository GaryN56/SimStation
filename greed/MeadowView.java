package greed;
import mvc.*;
import simstation.*;
import java.awt.*;

public class MeadowView extends WorldView {
    public MeadowView (Model m) {super(m); }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Meadow meadow = (Meadow) model;

        Patch[][] field = meadow.getField();
        for (int i = 0; i < Meadow.dim; i++) {
            for (int j = 0; j < Meadow.dim; j++) {
                drawPatch(field[i][j], i, j, gc);
            }
        }

        for (Agent a : meadow.agents) {
            if (a instanceof Cow c) {
                drawCow((Cow)a, gc);
            }
        }
    }

    public void drawPatch(Patch p, int i, int j, Graphics gc) {
        int x = i * Patch.PATCH_SIZE;
        int y = j * Patch.PATCH_SIZE;

        Color color;
        int energy = p.getEnergy();
        int newGreen = (int) (255 * (energy / 100.0));
        color = new Color(0, newGreen, 0);

        gc.setColor(color);
        gc.fillRect(x, y, Patch.PATCH_SIZE, Patch.PATCH_SIZE);
        gc.setColor(Color.WHITE);
        gc.drawRect(x, y, Patch.PATCH_SIZE, Patch.PATCH_SIZE);
    }

    public void drawCow(Cow c, Graphics gc) {
        int x = c.getXc();
        int y = c.getYc();
        if (c.isAlive()) {
            gc.setColor(Color.RED);
        } else {
            gc.setColor(Color.WHITE);
        }
        gc.fillOval(x - 3, y - 3, 6, 6);
    }
}
