
/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author Selin Ustaoglu (1533754)
 * @author Damla Savas (1533746)
 * assignment group 44
 * assignment copyright Kees Huizing
 */

import java.awt.Component;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

class PrisonersDilemma extends JFrame {
	
	private static final long serialVersionUID = 1L;

	void buildGUI() {
		SwingUtilities.invokeLater(() -> {
			setTitle("Prisoners Dilemma by Damla and Selin");
			setSize(500, 600);

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

			PlayingField playingField = new PlayingField();
			
			
			JPanel sliders = new JPanel();
			JSlider defection = new JSlider(JSlider.HORIZONTAL, 0, 3, 1);
			defection.setPaintLabels(true);
			Hashtable<Integer, JLabel> positionDefection = new Hashtable<>();
			positionDefection.put(0, new JLabel("0.0"));
			positionDefection.put(1, new JLabel("1.0"));
			positionDefection.put(2, new JLabel("2.0"));
			positionDefection.put(3, new JLabel("3.0"));
			defection.setLabelTable(positionDefection); 
			defection.addChangeListener(e -> playingField.setAlpha(defection.getValue()));

			
			JSlider frequency = new JSlider(JSlider.HORIZONTAL, 10, 60, 30);
			frequency.setPaintLabels(true);
			Hashtable<Integer, JLabel> positionFrequency = new Hashtable<>();
			positionFrequency.put(10, new JLabel("10"));
			positionFrequency.put(20, new JLabel("20"));
			positionFrequency.put(30, new JLabel("30"));
			positionFrequency.put(40, new JLabel("40"));
			positionFrequency.put(50, new JLabel("50"));
			positionFrequency.put(60, new JLabel("60"));
			frequency.setLabelTable(positionFrequency);
			frequency.addChangeListener(e -> {});
			
			sliders.add(defection);
			sliders.add(frequency);
			
			
			JPanel buttons = new JPanel();
			JButton goButton = new JButton("GO");
			JButton pauseButton = new JButton("Pause");
			JButton resetButton = new JButton("Reset");

			buttons.add(goButton);
			buttons.add(pauseButton);
			buttons.add(resetButton);

			panel.add(playingField);
			panel.add(sliders);
			panel.add(buttons);
			
			add(panel);

			playingField.setAlignmentX(Component.CENTER_ALIGNMENT);
			sliders.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

			playingField.setAlignmentY(Component.TOP_ALIGNMENT);
			sliders.setAlignmentY(Component.CENTER_ALIGNMENT);
			buttons.setAlignmentY(Component.BOTTOM_ALIGNMENT);


			pack();

			setVisible(true);

		});
	}

	// ...

	public static void main(String[] a) {
		(new PrisonersDilemma()).buildGUI();
	}
}
