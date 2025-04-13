package plague;
import mvc.*;
import simstation.*;
public class Host extends MobileAgent {
    private boolean infected = false;

    public void setInfected(boolean infected) {
        this.infected = infected;
    }
    public boolean isInfected() {
        return this.infected;
    }

    @Override
    public void update() {
        heading = Heading.random();
    }
}
