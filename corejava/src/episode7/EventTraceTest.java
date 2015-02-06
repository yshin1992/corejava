package episode7;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class EventTraceTest extends JFrame
{
	public EventTraceTest()
	{// 显示控制台
		ConsoleWindow.init();
		add( new JSlider(), BorderLayout.NORTH );
		add( new JButton( "Test" ), BorderLayout.SOUTH );
		EventTracer tracer = new EventTracer();
		tracer.add( this );
		setTitle( "EventTrace Test Frame" );
		setSize( 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new EventTraceTest();
	}

}
