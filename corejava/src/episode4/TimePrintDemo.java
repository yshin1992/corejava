package episode4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimePrintDemo {

	public static void main(String[] args) {
		PrintActionListener print=new PrintActionListener();
		Timer t=new Timer(3000,print);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program!");
		System.exit(0);
	}

}

class PrintActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("The Time now is "+new Date());
		Toolkit.getDefaultToolkit().beep();
	}
	
}
