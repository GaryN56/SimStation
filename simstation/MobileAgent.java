package simstation;

public class MobileAgent extends Agent {
    protected Heading heading;

    @Override
    void update() {
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            switch (heading) {
                case NORTH -> yc = (yc - 1 + World.SIZE) % World.SIZE;
                case SOUTH -> yc = (yc + 1) % World.SIZE;
                case EAST -> xc = (xc + 1) % World.SIZE;
                case WEST -> xc = (xc - 1 + World.SIZE) % World.SIZE;
            }
        }
    }

    public void turn(Heading dir) {
        heading = dir;
    }
}
