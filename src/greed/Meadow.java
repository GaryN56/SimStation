package greed;
import simstation.*;
public class Meadow extends World {
    public static int waitPenalty = 5;
    public static int moveEnergy = 10;
    public int numCows = 50;
    public static int dim = SIZE / Patch.PATCH_SIZE;
    public int aliveAmount;
    public int deadAmount;

    private Patch[][] field;

    public Patch[][] getField() {
        return field;
    }


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
    public void reset() {
        super.reset();
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

    public static void setMoveEnergy(int amt) {
        moveEnergy = amt;
    }

    @Override
    public void updateStatistics() {
        super.updateStatistics();
        aliveAmount = 0;
        deadAmount = 0;
        for (Agent a: agents) {
            if (a instanceof Cow c) {
                if (c.isAlive()) {
                    aliveAmount++;
                } else {
                    deadAmount++;
                }
            }
        }
    }

    @Override
    public String getStatus() {

        return "Total Cows: " + numCows + "\nAlive Cows: " + aliveAmount + "\nDead Cows: " + deadAmount;
    }
}
