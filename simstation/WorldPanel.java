package simstation;

import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class WorldPanel extends AppPanel {

    public JPanel threadPanel = new JPanel();
    protected World world;
    protected WorldView worldView;

    public WorldPanel(WorldFactory factory) {
        super(factory);

        threadPanel.setLayout(new GridLayout(1, 5));
        threadPanel.setOpaque(false);

        JPanel p = new JPanel();
        p.setOpaque(false);
        JButton button = new JButton("Start");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Pause");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Resume");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stop");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stats");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        controlPanel.setLayout(new BorderLayout());

        p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);

        controlPanel.add(p,  BorderLayout.NORTH);
    }

    public void setModel(Model m) {
        super.setModel(m);
        World w = (World) m;
        Iterator<Agent> it = w.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start();
        }
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            String cmmd = ae.getActionCommand();
            Command exec = null;
            switch (cmmd) {
                case "Start":
                    exec = new StartCommand(model);
                    break;
                case "Pause":
                    exec = new SuspendCommand(model);
                    break;
                case "Resume":
                    exec = new ResumeCommand(model);
                    break;
                case "Stop":
                    exec = new StopCommand(model);
                    break;
                case "Stats":
                    exec = new StatsCommand(model);
                    break;
            }
            if (exec != null) {
                exec.execute();
            }
        } catch (Exception e) {
            handleException(e);
        }
        super.actionPerformed(ae);
    }

    //protected View getView(Model model) { return new SimulationView(model); }

//    public void update() {
//        repaint();
//    }
}