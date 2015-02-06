package episode4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassDemo1 {

	/*
	 * 普通内部类
	 */
	private int interval;
	private boolean beep;
	
	public InnerClassDemo1(int interval,boolean beep){
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start(){
		TimerActionListener timeraction=new TimerActionListener();
		Timer timer=new Timer(interval,timeraction);
		timer.start();
	}
	
	public static void main(String[] args) {
		new InnerClassDemo1(2000,true).start();
		JOptionPane.showMessageDialog(null, "Quit program!");
		System.exit(0);
	}
	
	private class TimerActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Now Time is "+new Date());
			if(beep)
				Toolkit.getDefaultToolkit().beep();
		}
		
	}

}
