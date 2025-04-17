package simstation.prisonersDilemma;

public class Cheat extends Strategy {
    public Cheat(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return false;
    }
}
