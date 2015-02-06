package episode7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HelloWorld extends JApplet
{
	JFrame frame;


	@Override
	public void init()
	{
		setLayout( new FlowLayout() );
		add( new JLabel( "Hello,World!" ), SwingConstants.CENTER );
		JButton btn = new JButton( "Show JFrame" );
		btn.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				if (frame == null)
				{
					frame = new JFrame();
					frame.setTitle( "New Frame" );
					frame.setSize( 200, 200 );
				}
				frame.setVisible( true );
			}
		} );
		add( btn );
	}
}
