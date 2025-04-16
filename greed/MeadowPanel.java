package greed;
import mvc.AppPanel;
import simstation.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MeadowPanel extends WorldPanel implements ChangeListener {
    JPanel sliderPanel;
    JSlider greedSlider, growSlider, moveSlider;
    public MeadowPanel(WorldFactory factory) {
        super(factory);

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(6,1));
        sliderPanel.setOpaque(false);

        greedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
        greedSlider.setMinorTickSpacing(1);
        greedSlider.setMajorTickSpacing(10);
        greedSlider.setPaintTicks(true);
        greedSlider.setPaintLabels(true);
        greedSlider.setLabelTable(greedSlider.createStandardLabels(10));

        growSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        growSlider.setMinorTickSpacing(1);
        growSlider.setMajorTickSpacing(10);
        growSlider.setPaintTicks(true);
        growSlider.setPaintLabels(true);
        growSlider.setLabelTable(growSlider.createStandardLabels(2));

        moveSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 10);
        moveSlider.setMinorTickSpacing(1);
        moveSlider.setMajorTickSpacing(10);
        moveSlider.setPaintTicks(true);
        moveSlider.setPaintLabels(true);
        moveSlider.setLabelTable(moveSlider.createStandardLabels(10));

        greedSlider.addChangeListener( this);
        growSlider.addChangeListener( this);
        moveSlider.addChangeListener( this);

        // Adding greedSlider to control panel
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setOpaque(false);

        JPanel q1 = new JPanel();
        q1.setOpaque(false);
        q1.add(new JLabel("Greed:"));
        p1.add(q1, BorderLayout.NORTH);

        q1 = new JPanel();
        q1.setOpaque(false);
        q1.add(greedSlider);
        p1.add(q1, BorderLayout.CENTER);
        sliderPanel.add(p1);

        // Adding growSlider to control panel
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.setOpaque(false);

        JPanel q2 = new JPanel();
        q2.setOpaque(false);
        q2.add(new JLabel("Grow Back Rate: "));
        p2.add(q2, BorderLayout.NORTH);

        q2 = new JPanel();
        q2.setOpaque(false);
        q2.add(growSlider);
        p2.add(q2, BorderLayout.CENTER);
        sliderPanel.add(p2);

        // Adding moveSlider to control panel
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setOpaque(false);

        JPanel q3 = new JPanel();
        q3.setOpaque(false);
        q3.add(new JLabel("Move Energy:"));
        p3.add(q3, BorderLayout.NORTH);

        q3 = new JPanel();
        q3.setOpaque(false);
        q3.add(moveSlider);
        p3.add(q3, BorderLayout.CENTER);
        sliderPanel.add(p3);

        controlPanel.add(sliderPanel, BorderLayout.CENTER);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == greedSlider) {
            Cow.GREEDINESS = greedSlider.getValue();
        }
        if (e.getSource() == growSlider) {
            Patch.GROWTH_RATE = growSlider.getValue();
        }
        if (e.getSource() == moveSlider) {
            Meadow.moveEnergy = moveSlider.getValue();
        }
        model.changed();
    }

    public void update() {
        greedSlider.setValue(Cow.GREEDINESS);
        growSlider.setValue(Patch.GROWTH_RATE);
        moveSlider.setValue(Meadow.moveEnergy);
        repaint();
    }

    public static void main(String[] args) {
        AppPanel panel = new MeadowPanel(new MeadowFactory());
        panel.display();
    }
}
