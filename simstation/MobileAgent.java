package simstation;

public class MobileAgent extends Agent {
    protected Heading heading;

    public MobileAgent() {
        super();
    }

    public void move(int steps) {
//        switch(heading) {
//            case NORTH:
//                setYc(getYc() - steps);
//                break;
//            case SOUTH:
//                setYc(getYc() + steps);
//                break;
//            case EAST:
//                setXc(getXc() + steps);
//                break;
//            case WEST:
//                setXc(getXc() - steps);
//                break;
//        }
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
        this.heading = dir;
    }
}
