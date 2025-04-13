package simstation;

public class ObserverAgent extends Agent {


    @Override
    void update() {
        world.updateStatistics();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            onInterrupted();
        }
    }
}
