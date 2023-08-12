package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
	public void showButton() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        JButton button = new JButton();
        button.setText("push the button?");
       button.addActionListener(this);
        frame.add(button);
        frame.pack();
   }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,"Woohoo!");
	}
}
