package prisonersDilemma;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy {
    public RandomlyCooperate(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
//        int num = Utilities.rng.nextInt(2); // rolls between 0 and 1
//        return num == 0; // 0 = true
        return Utilities.rng.nextBoolean();
    }
}
