package episode4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassDemo3
{

	/*
	 * 匿名内部类
	 */
	private int interval;

	private boolean beep;


	public InnerClassDemo3(int interval, boolean beep)
	{
		this.interval = interval;
		this.beep = beep;
	}


	public void start(final boolean beep)
	{
		// 匿名内部类
		Timer timer = new Timer( interval, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println( "Now Time is " + new Date() );
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}
		} );
		timer.start();
	}


	public static void main(String[] args)
	{
		new InnerClassDemo3( 2000, true ).start( false );
		JOptionPane.showMessageDialog( null, "Quit program!" );
		System.exit( 0 );
	}

}