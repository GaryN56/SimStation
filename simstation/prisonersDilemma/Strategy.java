package simstation.prisonersDilemma;

public abstract class Strategy {
    protected Prisoner myPrisoner;
    public Strategy(Prisoner myPrisoner) {
        this.myPrisoner = myPrisoner;
    }
    public abstract boolean cooperate();
}
