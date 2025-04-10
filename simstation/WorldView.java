package simstation;

import mvc.Model;
import mvc.View;

public class WorldView extends View {
    World w;

    public WorldView(Model m) {
        super(m); // dk wat this does, intellij told me to add it
        w = (World) m;
    }
}
