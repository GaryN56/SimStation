package prisonersDilemma;

public class Tit4Tat extends Strategy {
    public Tit4Tat(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return !myPrisoner.getPartnerCheated();
    }
}
