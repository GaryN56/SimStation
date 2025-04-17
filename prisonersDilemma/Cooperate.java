package prisonersDilemma;

public class Cooperate extends Strategy {
    public Cooperate(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return true;
    }
}
