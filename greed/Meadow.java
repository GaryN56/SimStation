package greed;
import simstation.*;
public class Meadow extends World {
    public int waitPenalty = 5;
    public int moveEnergy = 10;
    public int numCows = 50;
    public int dim = SIZE / Patch.PATCH_SIZE;

    private Patch[][] field;

    public Meadow() {
        field = new Patch[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                field[i][j] = new Patch();
                addAgent(field[i][j]);
            }
        }
    }

    @Override
    public void populate() {
        for (int i = 0; i < numCows; i++) {
            addAgent(new Cow());
        }
    }
    public Patch getPatch(int xc, int yc) {
        int x = Math.max(0, Math.min(xc / Patch.PATCH_SIZE, dim - 1));
        int y = Math.max(0, Math.min(yc / Patch.PATCH_SIZE, dim - 1));
        return field[x][y];
    }
}
