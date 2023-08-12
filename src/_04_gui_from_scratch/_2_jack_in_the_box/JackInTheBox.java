package _04_gui_from_scratch._2_jack_in_the_box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JackInTheBox implements ActionListener{
	public void showButton() {
		JFrame frame = new JFrame();
		JButton button = new JButton();
		button.setText("Surprise!");
		button.addActionListener(this);
		frame.add(button);
		frame.setVisible(true);
		frame.pack();
		
	//showPicture();
	}
	
	private void showPicture() {
		Icon icon = new ImageIcon("src/_04_gui_from_scratch/_2_jack_in_the_box/jackInTheBox.png");
		JLabel label = new JLabel(icon);
	          
	          JFrame frame = new JFrame();
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.add(label);
	          frame.setVisible(true);
	          frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		if(ran.nextInt(5)==4) {
			showPicture();
		}
	}

	
	

	

}