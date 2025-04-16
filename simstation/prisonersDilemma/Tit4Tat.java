package simstation.prisonersDilemma;

public class Tit4Tat extends Strategy {
    private boolean lastOpponentCooperated;

    public void updateOpponentCheated(boolean cooperated) {
        this.lastOpponentCooperated = cooperated;
    }

    @Override
    public boolean cooperate() {
        return lastOpponentCooperated;
    }
}
