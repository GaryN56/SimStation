package simstation.prisonersDilemma;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy {
    @Override
    public boolean cooperate() {
        int num = Utilities.rng.nextInt(2); // rolls between 0 and 1
        return num == 0; // 0 = true
    }
}
