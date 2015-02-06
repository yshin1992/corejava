package episode5;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiCastDmo extends JFrame
{

	public MultiCastDmo()
	{
		setSize( 300, 300 );
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( size.width - 400, 100 );
		CloseJPanel panel = new CloseJPanel();
		add( panel );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MultiCastDmo();
	}

}

class CloseJPanel extends JPanel
{
	public CloseJPanel()
	{
		JButton newbtn = new JButton( "New Frame" );
		final JButton closebtn = new JButton( "Close All Frame" );
		newbtn.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				new BlankFrame( closebtn );
			}
		} );
		add( newbtn );
		add( closebtn );
	}

}

class BlankFrame extends JFrame
{
	private static int count = 0;

	private static final int WIDTH = 200;

	private static final int HEIGHT = 200;


	public BlankFrame(final JButton closebtn)
	{
		count++;
		setSize( WIDTH, HEIGHT );
		setTitle( "Frame " + count );
		setLocation( WIDTH + count * 20, HEIGHT + count * 20 );
		closebtn.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				closebtn.removeActionListener( this );
				BlankFrame.this.dispose();
			}
		} );
		setVisible( true );
		// setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
}
