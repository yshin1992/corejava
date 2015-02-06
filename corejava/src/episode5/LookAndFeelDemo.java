package episode5;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeelDemo extends JFrame
{

	/*
	 * Swing感观控制
	 */
	public LookAndFeelDemo()
	{
		setTitle( "感观控制" );
		setSize( 400, 300 );
		LookPanel panel = new LookPanel();
		add( panel );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (screenSize.width - 300) / 2, (screenSize.height - 200) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		addWindowListener( new WindowAdapter()
		{
			@Override
			public void windowActivated(WindowEvent windowevent)
			{
				super.windowActivated( windowevent );
				System.out.println( "Window Active" );
			}


			@Override
			public void windowClosed(WindowEvent windowevent)
			{
				super.windowClosed( windowevent );
				System.out.println( "Window Closed" );
			}


			@Override
			public void windowClosing(WindowEvent windowevent)
			{
				super.windowClosing( windowevent );
				System.out.println( "Window Closing" );
			}


			@Override
			public void windowLostFocus(WindowEvent windowevent)
			{
				super.windowLostFocus( windowevent );
				System.out.println( "Window LostFocus" );
			}


			@Override
			public void windowOpened(WindowEvent windowevent)
			{
				super.windowOpened( windowevent );
				System.out.println( "Window Opened" );
			}


			@Override
			public void windowStateChanged(WindowEvent windowevent)
			{
				super.windowStateChanged( windowevent );
				System.out.println( "Window StateChanged" );
			}

		} );
	}


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new LookAndFeelDemo();
	}
}

class LookPanel extends JPanel
{
	private static JButton[] btns;


	public LookPanel()
	{
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		btns = new JButton[infos.length];
		for ( int i = 0; i < infos.length; i++ )
		{
			btns[i] = new JButton( infos[i].getName() );
			final String look = infos[i].getClassName();
			btns[i].addActionListener( new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent actionevent)
				{
					try
					{
						UIManager.setLookAndFeel( look );
						SwingUtilities.updateComponentTreeUI( LookPanel.this );
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			} );
			add( btns[i] );
		}

	}
}
