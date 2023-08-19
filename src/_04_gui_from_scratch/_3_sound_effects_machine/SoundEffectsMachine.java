package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SoundEffectsMachine implements ActionListener {
JButton sawButton;
JButton spyButton;

	public void showButton() {
		JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.add(panel);
        sawButton = new JButton();
        sawButton.setText("sawing wood");
        sawButton.addActionListener(this);
        panel.add(sawButton);
        spyButton = new JButton();
        spyButton.setText("spy sound");
        spyButton.addActionListener(this);
        panel.add(spyButton);
        
        frame.pack();
   }
public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		// TODO Auto-generated method stub
		if(buttonPressed==sawButton) {
			playSound("sawing-wood-daniel_simon.wav");
		}
		if(buttonPressed==spyButton) {
			playSound("Spy_uncloak_feigndeath.wav");
		}
		
	}
	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}
}
