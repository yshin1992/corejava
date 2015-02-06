package episode5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventListenerDemo extends JFrame
{

	public KeyEventListenerDemo()
	{
		setTitle( "keyListener Demo" );
		setSize( 400, 300 );
		KeyPanel panel = new KeyPanel();
		add( panel );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (screenSize.width - 300) / 2, (screenSize.height - 200) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new KeyEventListenerDemo();
	}

}

class KeyPanel extends JPanel
{

	private StringBuffer sb;


	public KeyPanel()
	{
		sb = new StringBuffer();
		setFocusable( true );
		addKeyListener( new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent keyevent)
			{
				sb.append( keyevent.getKeyChar() );
				System.out.print( keyevent.getKeyChar() );
				KeyPanel.this.repaint();
			}


			@Override
			public void keyReleased(KeyEvent keyevent)
			{
				// TODO Auto-generated method stub

			}


			@Override
			public void keyPressed(KeyEvent keyevent)
			{
				// TODO Auto-generated method stub
				if (keyevent.getKeyCode() == KeyEvent.VK_LEFT && keyevent.isShiftDown())
					System.out.println( "Shift <---" );
			}
		} );
	}


	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paint( g );
		g.drawString( sb.toString(), 10, 10 );

	}

}
