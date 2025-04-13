package simstation;

public class ObserverAgent extends Agent {
    @Override
    void update() {
        world.updateStatistics();
    }
}
