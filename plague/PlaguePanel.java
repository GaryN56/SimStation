package plague;
import mvc.AppPanel;
import simstation.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlaguePanel extends WorldPanel implements ChangeListener {
    JPanel sliderPanel = new JPanel();
    JSlider infectedSlider, probabilitySlider, populationSlider, timeSlider;
    JButton fatalButton;
    public PlaguePanel(WorldFactory factory) {
        super(factory);

        sliderPanel.setLayout(new GridLayout(6,1));
        sliderPanel.setOpaque(false);

        infectedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 5);
        infectedSlider.setMinorTickSpacing(1);
        infectedSlider.setMajorTickSpacing(10);
        infectedSlider.setPaintTicks(true);
        infectedSlider.setPaintLabels(true);
        infectedSlider.setLabelTable(infectedSlider.createStandardLabels(10));

        probabilitySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        probabilitySlider.setMinorTickSpacing(1);
        probabilitySlider.setMajorTickSpacing(10);
        probabilitySlider.setPaintTicks(true);
        probabilitySlider.setPaintLabels(true);
        probabilitySlider.setLabelTable(probabilitySlider.createStandardLabels(10));

        populationSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 50);
        populationSlider.setPreferredSize(new Dimension(350, 50));
        populationSlider.setMinorTickSpacing(1);
        populationSlider.setMajorTickSpacing(20);
        populationSlider.setPaintTicks(true);
        populationSlider.setPaintLabels(true);
        populationSlider.setLabelTable(populationSlider.createStandardLabels(20));

        timeSlider = new JSlider(JSlider.HORIZONTAL, 0, 500, 200);
        timeSlider.setPreferredSize(new Dimension(350, 50));
        timeSlider.setMinorTickSpacing(1);
        timeSlider.setMajorTickSpacing(50);
        timeSlider.setPaintTicks(true);
        timeSlider.setPaintLabels(true);
        timeSlider.setLabelTable(timeSlider.createStandardLabels(50));

        infectedSlider.addChangeListener( this);
        probabilitySlider.addChangeListener( this);
        populationSlider.addChangeListener( this);
        timeSlider.addChangeListener( this);



        // Adding infectedSlider to control panel
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setOpaque(false);

        JPanel q1 = new JPanel();
        q1.setOpaque(false);
        q1.add(new JLabel("Initial % Infected:"));
        p1.add(q1, BorderLayout.NORTH);

        q1 = new JPanel();
        q1.setOpaque(false);
        q1.add(infectedSlider);
        p1.add(q1, BorderLayout.CENTER);
        sliderPanel.add(p1);

        // Adding probabilitySlider to control panel
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.setOpaque(false);

        JPanel q2 = new JPanel();
        q2.setOpaque(false);
        q2.add(new JLabel("Infection Probability:"));
        p2.add(q2, BorderLayout.NORTH);

        q2 = new JPanel();
        q2.setOpaque(false);
        q2.add(probabilitySlider);
        p2.add(q2, BorderLayout.CENTER);
        sliderPanel.add(p2);

        // Adding populationSlider to control panel
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setOpaque(false);

        JPanel q3 = new JPanel();
        q3.setOpaque(false);
        q3.add(new JLabel("Initial Population Size:"));
        p3.add(q3, BorderLayout.NORTH);

        q3 = new JPanel();
        q3.setOpaque(false);
        q3.add(populationSlider);
        p3.add(q3, BorderLayout.CENTER);
        sliderPanel.add(p3);

        // Adding timeSlider to control panel
        JPanel p4 = new JPanel();
        p4.setLayout(new BorderLayout());
        p4.setOpaque(false);

        JPanel q4 = new JPanel();
        q4.setOpaque(false);
        q4.add(new JLabel("Fatality/Recovery time:"));
        p4.add(q4, BorderLayout.NORTH);

        q4 = new JPanel();
        q4.setOpaque(false);
        q4.add(timeSlider);
        p4.add(q4, BorderLayout.CENTER);
        sliderPanel.add(p4);

        // Adding fatal button
        fatalButton = new JButton("Not Fatal");
        fatalButton.addActionListener( e-> {
            PlagueSimulation.FATAL = !PlagueSimulation.FATAL;
            fatalButton.setText(PlagueSimulation.FATAL ? "Fatal" : "Not Fatal");
                });

        JPanel p5 = new JPanel();
        p5.setOpaque(false);
        p5.add(fatalButton);
        sliderPanel.add(p5);

        controlPanel.add(sliderPanel, BorderLayout.CENTER);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == infectedSlider) {
            PlagueSimulation.INITIAL_INFECTED = infectedSlider.getValue();
        }
        if (e.getSource() == probabilitySlider) {
            PlagueSimulation.VIRULENCE = probabilitySlider.getValue();
        }
        if (e.getSource() == populationSlider) {
            PlagueSimulation.POPULATION_SIZE = populationSlider.getValue();
        }
        if (e.getSource() == timeSlider) {
            PlagueSimulation.INFECTION_LENGTH = timeSlider.getValue();
        }
        model.changed();
    }

    public void update() {
        infectedSlider.setValue(((PlagueSimulation) model).INITIAL_INFECTED);
        probabilitySlider.setValue(((PlagueSimulation) model).VIRULENCE);
        populationSlider.setValue(((PlagueSimulation) model).POPULATION_SIZE);
        timeSlider.setValue(((PlagueSimulation) model).INFECTION_LENGTH);
        repaint();
    }

    public static void main(String[] args) {
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}