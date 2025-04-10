package simstation;

public class ObserverAgent extends Agent {

    @Override
    void start() {

    }

    @Override
    void stop() {

    }

    @Override
    void pause() {

    }

    @Override
    void resume() {

    }

    @Override
    boolean done() {
        return false;
    }

    @Override
    void update() {
        world.updateStatistics();
    }
}
