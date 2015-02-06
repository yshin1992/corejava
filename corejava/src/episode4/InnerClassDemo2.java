package episode4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassDemo2
{

	/*
	 * 局部内部类
	 */
	private int interval;


	public InnerClassDemo2(int interval)
	{
		this.interval = interval;
	}


	public void start(final boolean beep)
	{
		// 局部内部类不仅能访问外部类的属性，还能访问内部变量，但这些变量需要声明为final
		class TimerActionListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println( "Now Time is " + new Date() );
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}

		}
		TimerActionListener timeraction = new TimerActionListener();
		Timer timer = new Timer( interval, timeraction );
		timer.start();
	}


	public static void main(String[] args)
	{
		new InnerClassDemo2( 2000 ).start( false );
		JOptionPane.showMessageDialog( null, "Quit program!" );
		System.exit( 0 );
	}

}